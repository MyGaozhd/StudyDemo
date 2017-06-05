package com.gaozhd.studydemo.androidbase.xmlparser;

import android.app.AlarmManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.androidbase.webservice.WebServiceRequest;
import com.gaozhd.studydemo.utils.LogUtil;

import org.xmlpull.v1.XmlSerializer;

import java.io.StringWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: XmlParserActivity
 * @Description: ${todo}
 * @Date: 2017/5/19 0019 8:55
 */
public class XmlParserActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv2)
    TextView tv2;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(XmlParserActivity.this, (String) msg.obj, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xml_parser_activity);
        ButterKnife.bind(this);
    }

    private String getXmlString() {
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("\n");
        xmlContent.append("<req oid=\"" + "调用者ID号\"" + " oke=\"" + "项目校验码\"" + ">");
        xmlContent.append("\n");
        xmlContent.append("<cano>" + "卡片号" + "</cano>");
        xmlContent.append("\n");
        xmlContent.append("<qrco>" + "二维码" + "</qrco>");
        xmlContent.append("\n");
        xmlContent.append("</req>");

        return xmlContent.toString();
    }

    public static final String KEY_OID = "999";
    public static final String KEY_OKE = "YzGD6Lzfd1s=";

    public static String getCardCheckXmlString(String ma) {
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("\n");
        xmlContent.append("<req oid=\"" + KEY_OID + "\"" + " oke=\"" + KEY_OKE
                + "\"" + ">");
        xmlContent.append("\n");
        xmlContent.append("<cano>" + "" + "</cano>");
        xmlContent.append("\n");
        xmlContent.append("<qrco>" + ma + "</qrco>");
        xmlContent.append("\n");
        xmlContent.append("</req>");

        LogUtil.log(xmlContent.toString());
        return xmlContent.toString();
    }

    private String parserXmlString() {

        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        xmlContent.append("\n");
        xmlContent.append("<res rcd=\"0\">");
        xmlContent.append("\n");
        xmlContent.append("<stco>员工代码</stco>");
        xmlContent.append("\n");
        xmlContent.append("<stno>员工号</stno>");
        xmlContent.append("\n");
        xmlContent.append("<stna>员工姓名</stna>");
        xmlContent.append("\n");
        xmlContent.append("</req>");

        String result = xmlContent.toString() + "\n";
        Pattern p1 = Pattern.compile("<stco>.*</stco>");
        Matcher m1 = p1.matcher(xmlContent.toString());

        while (m1.find()) {
            result += m1.group().replace("<stco>", "").replace("</stco>", "") + "\n";
        }

        Pattern p2 = Pattern.compile("<stno>.*</stno>");
        Matcher m2 = p2.matcher(xmlContent.toString());

        while (m2.find()) {
            result += m2.group().replace("<stno>", "").replace("</stno>", "") + "\n";
        }

        Pattern p = Pattern.compile("<stna>.*</stna>");
        Matcher m = p.matcher(xmlContent.toString());

        while (m.find()) {
            result += m.group().replace("<stna>", "").replace("</stna>", "");
        }

        return result;
    }

    @OnClick({R.id.btn, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
//                tv.setText(getCardCheckXmlString("YG|db9efe62-67f8-45dc-b49a-d1fa3e76e9ca"));
                String[] x = new String[]{"A", "B", "C"};
                String[] y = new String[]{"1", "2", "3"};
                tv.setText(writeXmlSerial(x, y));
                break;
            case R.id.btn2:
////                tv2.setText(parserXmlString());
//                WebServiceRequest request = new WebServiceRequest(handler);
//                request.doCardCheckRequest();
//                tv2.setText(WebServiceRequest.getUserCheckXmlString("200108", "530"));
                Map<String, String> resultMap = WebServiceRequest
                        .parserUserCheckResultXmlString("");
                if (resultMap != null && resultMap.containsKey("user_number")
                        && resultMap.containsKey("user_name")) {

                } else {
                    Toast.makeText(XmlParserActivity.this, "密码校验失败",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public static String writeXmlSerial(String[] x, String[] y) {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            int i = x.length;
            // <?xml version=”1.0″ encoding=”UTF-8″ standalone=”yes”?>
            serializer.startDocument("UTF-8", true);
            serializer.startTag("kkk", "list");
            for (int j = 0; j < i; j++) {
                serializer.startTag(null, x[j]);
                serializer.text(y[j]);
                serializer.endTag(null, x[j]);
            }
            serializer.endTag("kkk", "list");
            serializer.endDocument();
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
