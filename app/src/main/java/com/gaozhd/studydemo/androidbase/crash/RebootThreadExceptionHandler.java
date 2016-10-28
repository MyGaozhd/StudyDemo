
package com.gaozhd.studydemo.androidbase.crash;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RebootThreadExceptionHandler implements UncaughtExceptionHandler {

    private Context context;
    private String hintText = "很抱歉，程序异常，即将重启！";
    private static RebootThreadExceptionHandler INSTANCE = null;

    public static RebootThreadExceptionHandler getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RebootThreadExceptionHandler(context);
        }
        return INSTANCE;
    }

    private RebootThreadExceptionHandler(Context context) {
        this.context = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();// 输出异常信息到控制台

        if (true) {
            /* 启动新线程提示程序异常 */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Toast.makeText(context, hintText, Toast.LENGTH_SHORT)
                            .show();
                    Looper.loop();
                }
            }).start();

			/* 主线程等待1秒钟，让提示信息显示出来 */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

		/* 设置定时器，在1秒钟后发出启动程序的广播 */
        AlarmManager alarmManager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.SECOND, 1);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                PendingIntent.getBroadcast(context, 0, new Intent(context,
                        StartAppReceiver.class), 0));

        android.os.Process.killProcess(android.os.Process.myPid()); // 结束程序
    }

}
