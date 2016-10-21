package com.gaozhd.studydemo.utils;

import android.os.Looper;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ThreedUtil
 * @Description: ${todo}
 * @date 2016/10/18 21:20
 */
public class ThreedUtil {

    /**
     * @Title: isMainThreed
     * @Description: 是否是主线程
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/18 21:21
     */
    public static boolean isMainThreed() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void logMainThreed() {
//        LogUtil.log("main threed ID=" + Looper.getMainLooper().getThread().getId() + " ,Name=" + Looper.getMainLooper().getThread().getName());

        LogUtil.log("current threed ID=" + Thread.currentThread().getId() + " ,Name=" + Thread.currentThread().getName());
    }

    public static void logCurrentThreed() {
        LogUtil.log("current threed ID=" + Thread.currentThread().getId() + " ,Name=" + Thread.currentThread().getName());
    }
}
