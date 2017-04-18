package com.gaozhd.studydemo.androidbase.webview;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by grishberg on 08.02.17.
 */
public class CommonWebClient extends WebViewClient {
    private static final String TAG = CommonWebClient.class.getSimpleName();
    public static final String SUCCESS_TAG = "success";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.d(TAG, "shouldOverrideUrlLoading: " + url);
        if (url.contains(SUCCESS_TAG)) {
            Log.d(TAG, "shouldOverrideUrlLoading: success");
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Log.d(TAG, "onPageStarted: " + url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.d(TAG, "onPageFinished: " + url);
    }
}
