package com.gaozhd.studydemo.utils;

import android.util.Log;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LogUtil
 * @Description: ${todo}
 * @date 2016/10/18 19:54
 */
public class LogUtil {
    private static final String TAG = "gaozhd";

    public static void log(String text) {
        Log.d(TAG, text);
    }
}
