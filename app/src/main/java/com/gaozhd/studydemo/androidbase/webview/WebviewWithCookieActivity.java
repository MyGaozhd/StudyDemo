package com.gaozhd.studydemo.androidbase.webview;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: WebviewWithCookieActivity
 * @Description: ${todo}
 * @Date: 2017/4/5 0005 14:42
 */
public class WebviewWithCookieActivity extends BaseActivity {

    private static final String TAG = "gaozhd";
    private static final String BASE_URL = "http://10.0.3.2:5000";
    public static final String URL = "http://42.120.41.126/zentaopms/www/task-view-8012.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview_with_cookie);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new CommonWebClient());

        String cookies = String.format(Locale.US, "keepLogin=on;lang=zh-cn;sid=a2t53t7kgujjqsopaeqs10d600;theme=default;windowHeight=925;windowHeight=976;za=gaozhidong;zp=5fc1a419e9f2b4c32c04c56f9f5fc090c7cd7f7d;windowWidth=1922;windowWidth=1918",
                new Date().getTime());
        clearCookies(this);

        Map<String, String> header = new HashMap<>();
        header.put("Cookie", cookies);
        webView.loadUrl(URL, header);
    }

    public static void clearCookies(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            Log.e(TAG, "Using clearCookies code for API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
            Log.e(TAG, "Using clearCookies code for API <" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(context);
            cookieSyncMngr.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }
}
