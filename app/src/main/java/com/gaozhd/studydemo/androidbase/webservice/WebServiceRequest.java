package com.gaozhd.studydemo.androidbase.webservice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.gaozhd.studydemo.utils.LogUtil;

public class WebServiceRequest {

    public static final String PARAM_KEY = "RequestXml";

    public static final int WEBSERVICE_HANDLE_CARD_CHECK_REQUEST = -1001;
    public static final int WEBSERVICE_HANDLE_USER_CHECK_REQUEST = -1002;

    // public static final String KEY_OID = "999";
    // public static final String KEY_OKE = "YzGD6Lzfd1s=";
    // private String endPoint ="http://192.168.12.236:3088/AppWebService.asmx";

    public static final String KEY_OID = "008";
    public static final String KEY_OKE = "ahJpAk57Frk=";
    // private String endPoint = "http://192.168.0.160:7088/AppWebService.asmx";
    private String endPoint = "http://192.168.12.236:7088/AppWebService.asmx";

    private String namespace = "http://j.org/";
    private String methodName = "GetStaffCardCheck";
    private Map<String, String> params;
    private Handler handler;

    public WebServiceRequest(Handler handler) {
        this.handler = handler;
    }

    public WebServiceRequest(String endPoint, String namespace,
                             String methodName, Map<String, String> params, Handler handler) {

        this.endPoint = endPoint;
        this.namespace = namespace;
        this.methodName = methodName;
        this.params = params;
        this.handler = handler;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void doCardCheckRequest() {
        new Thread() {
            public void run() {
                createRequest(WEBSERVICE_HANDLE_CARD_CHECK_REQUEST);
                // checkUserLogin();

            }

            ;
        }.start();
    }

    public void doUserCheckRequest() {
        new Thread() {
            public void run() {
                createRequest(WEBSERVICE_HANDLE_USER_CHECK_REQUEST);
            }

            ;
        }.start();
    }

    public void createRequest(int what) {

        // 获取返回的结果
        StringBuilder result = new StringBuilder();

        // SOAP Action
        String soapAction = namespace + methodName;

        SoapObject request = new SoapObject(namespace, methodName);

        // 传入参数
        for (String key : params.keySet()) {
            request.addProperty(key, params.get(key));
        }

        // 创建SoapSerializationEnvelope 对象，同时指定soap版本号(之前在wsdl中看到的)
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapSerializationEnvelope.VER11);
        envelope.dotNet = true;
        envelope.bodyOut = request;// 由于是发送请求，所以是设置bodyOut
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(endPoint);
        try {
            // 调用WebService
            httpTransportSE.call(soapAction, envelope);
            // 获取返回的数据
            SoapObject object = (SoapObject) envelope.bodyIn;

            for (int i = 0; i < object.getPropertyCount(); i++) {
                Log.e("gaozhd", object.getProperty(i).toString());
                result.append(object.getProperty(i).toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
            result.append(e.getMessage());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            result.append(e.getMessage());
        }

        if (handler != null) {
            Message msg = handler.obtainMessage();
            msg.obj = result.toString();
            msg.what = what;
            handler.sendMessage(msg);
        }
    }

    // 检测帐号登录状态
    public void checkUserLogin() {

        try {

            // String urlPath = "http://192.168.1.9:80/JJKSms/RecSms.php";
            URL url = new URL(endPoint);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url
                    .openConnection();
            httpURLConnection.setConnectTimeout(200000); // 设置连接超时时间
            httpURLConnection.setDoInput(true); // 打开输入流，以便从服务器获取数据
            httpURLConnection.setDoOutput(true); // 打开输出流，以便向服务器提交数据
            httpURLConnection.setRequestMethod("POST"); // 设置以Post方式提交数据
            httpURLConnection.setUseCaches(false); // 使用Post方式不能使用缓存
            // 设置请求体的类型是文本类型
            httpURLConnection.setRequestProperty("Content-Type", "text/xml");

            // 获得输出流，向服务器写入数据
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(A_STRING.getBytes("UTF-8"));

            int response = httpURLConnection.getResponseCode(); // 获得服务器的响应码
            if (response == HttpURLConnection.HTTP_OK) {
                InputStream inptStream = httpURLConnection.getInputStream();
                String resultString = dealResponseResult(inptStream);
                if (handler != null) {
                    Message msg = handler.obtainMessage();
                    msg.obj = resultString.toString();
                    msg.what = WEBSERVICE_HANDLE_CARD_CHECK_REQUEST;
                    handler.sendMessage(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (handler != null) {
                Message msg = handler.obtainMessage();
                msg.obj = e.getMessage();
                msg.what = WEBSERVICE_HANDLE_CARD_CHECK_REQUEST;
                handler.sendMessage(msg);
            }
        }
    }

    /*
     * Function : 处理服务器的响应结果（将输入流转化成字符串） Param : inputStream服务器的响应输入流
     */
    public static String dealResponseResult(InputStream inputStream) {
        String resultData = null; // 存储处理结果
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }

    public static final String A_STRING = "<v:Envelope xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:d=\"http://www.w3.org/2001/XMLSchema\" xmlns:c=\"http://www.w3.org/2003/05/soap-encoding\" xmlns:v=\"http://www.w3.org/2003/05/soap-envelope\"><v:Header/><v:Body><GetStaffCardCheck xmlns=\"http://j.org/\" id=\"o0\" c:root=\"1\"><RequestXml i:type=\"d:string\">&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;&lt;req oid=\"008\" oke=\"ahJpAk57Frk=\"&gt;&lt;cano&gt;&lt;/cano&gt;&lt;qrco&gt;YG|85541ed4-1c3d-4fd8-b026-2299a8f3d6bd&lt;/qrco&gt;&lt;/req&gt;</RequestXml></GetStaffCardCheck></v:Body></v:Envelope>";

    public static String getCardCheckXmlString(String ma) {
        StringBuilder xmlContent = new StringBuilder();
        // xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("<req oid=\"" + KEY_OID + "\"" + " oke=\"" + KEY_OKE
                + "\"" + ">");
        xmlContent.append("<cano>" + "" + "</cano>");
        xmlContent.append("<qrco>" + ma + "</qrco>");
        xmlContent.append("</req>");

        return xmlContent.toString();
    }

    public static String parserCardCheckResultXmlString(String xmlContent) {

        if (TextUtils.isEmpty(xmlContent)) {
            return "";
        }

        String result = "";

        Pattern p = Pattern.compile("<stno>.*</stno>");
        Matcher m = p.matcher(xmlContent.toString());

        while (m.find()) {
            result += m.group().replace("<stno>", "").replace("</stno>", "");
        }

        return result;
    }

    public static String getUserCheckXmlString(String user_number,
                                               String user_password) {
        StringBuilder xmlContent = new StringBuilder();
//		xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("<req oid=\"" + KEY_OID + "\"" + " oke=\"" + KEY_OKE
                + "\"" + ">");
        xmlContent.append("<enus>" + user_number + "</enus>");
        xmlContent.append("<enpa>" + user_password + "</enpa>");
        xmlContent.append("</req>");
        LogUtil.log(xmlContent.toString());
        return xmlContent.toString();
    }

    public static Map<String, String> parserUserCheckResultXmlString(
            String xmlContent) {

        xmlContent="<?xml version=\"1.0\" encoding=\"utf-8\" ?><res rcd=\"0\"><usid>200108</usid><usna>彭陆贵</usna><emid>76545</emid><tiid>035</tiid><tina>彭陆贵</tina><dept><dena>肿瘤内科</dena><deid>43500</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>肿瘤内科病房</dena><deid>4350001</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>神经内科</dena><deid>43900</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>神经内科病房</dena><deid>4390001</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>心血管内科</dena><deid>44000</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>心血管内科病房</dena><deid>4400001</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>血液内科</dena><deid>44700</deid><wkna>护理</wkna><wkid>40</wkid></dept><dept><dena>血液内科病房</dena><deid>4470001</deid><wkna>护理</wkna><wkid>40</wkid></dept></res>";

        if (TextUtils.isEmpty(xmlContent)) {
            return null;
        }

        Map<String, String> result = new HashMap<String, String>();

        Pattern p = Pattern.compile("<usid>.*</usid>");
        Matcher m = p.matcher(xmlContent.toString());

        while (m.find()) {
            result.put("user_number",
                    m.group().replace("<usid>", "").replace("</usid>", ""));
        }

        Pattern p1 = Pattern.compile("<usna>.*</usna>");
        Matcher m1 = p.matcher(xmlContent.toString());

        while (m1.find()) {
            result.put("user_name",
                    m1.group().replace("<usna>", "").replace("</usna>", ""));
        }
        return result;
    }

    private static String parserXmlString() {

        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("<res rcd=\"0\">");
        xmlContent.append("<stco>员工代码</stco>");
        xmlContent.append("<stno>员工号</stno>");
        xmlContent.append("<stna>员工姓名</stna>");
        xmlContent.append("</req>");

        String result = xmlContent.toString();
        Pattern p1 = Pattern.compile("<stco>.*</stco>");
        Matcher m1 = p1.matcher(xmlContent.toString());

        while (m1.find()) {
            result += m1.group().replace("<stco>", "").replace("</stco>", "");
        }

        Pattern p2 = Pattern.compile("<stno>.*</stno>");
        Matcher m2 = p2.matcher(xmlContent.toString());

        while (m2.find()) {
            result += m2.group().replace("<stno>", "").replace("</stno>", "");
        }

        Pattern p = Pattern.compile("<stna>.*</stna>");
        Matcher m = p.matcher(xmlContent.toString());

        while (m.find()) {
            result += m.group().replace("<stna>", "").replace("</stna>", "");
        }

        return result;
    }
}
