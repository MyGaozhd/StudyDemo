package com.gaozhd.studydemo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

/**
 * 系统工具箱
 */
public class SystemUtil {

    /**
     * @title: inMainProcess
     * @description: 当前进程是主进程
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/12/26 0026 20:53
     */
    public static boolean inMainProcess(Context context) {
        String packageName = context.getPackageName();
        String processName = SystemUtil.getProcessName(context);
        LogUtil.log("PackageName:" + packageName + "\n" + "ProcessName:" + processName);
        return packageName.equals(processName);
    }

    /**
     * 获取当前进程名
     *
     * @param context
     * @return 进程名
     */
    public static final String getProcessName(Context context) {
        String processName = null;

        // ActivityManager
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));

        while (true) {
            for (ActivityManager.RunningAppProcessInfo info : am.getRunningAppProcesses()) {
                if (info.pid == android.os.Process.myPid()) {
                    processName = info.processName;

                    break;
                }
            }

            // go home
            if (!TextUtils.isEmpty(processName)) {
                return processName;
            }

            // take a rest and again
            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
