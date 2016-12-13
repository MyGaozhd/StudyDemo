package com.gaozhd.studydemo;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import com.gaozhd.studydemo.androidbase.crash.RebootThreadExceptionHandler;
import com.gaozhd.studydemo.androidbase.greendao.DataBaseHelper;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class GlobalInfoApplication extends Application {

    private static GlobalInfoApplication appInstance;

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    private Activity currentActivity;

    public static GlobalInfoApplication getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;

        //leakcanary初始化
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        // 程序异常关闭1s之后重新启动
        RebootThreadExceptionHandler.getInstance(getBaseContext());
    }

    /**
     * @throws
     * @Title: initDataBase
     * @Description: 临时创建yidonghuli.db，便于Android端各模块开发
     * @param:
     * @return: void
     */
    public void initDataBase() {
        /* 判断程序是否第一次运行，如果是，则导入静态数据库 */
        Boolean firstInFlag = false;
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "studydemo", MODE_PRIVATE);
        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        firstInFlag = sharedPreferences.getBoolean("firstInFlag", true);
        // 判断是否第一次运行
        if (firstInFlag) {

            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            dataBaseHelper.createDataBase(this);
            // 写入标志位
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstInFlag", false);
            editor.commit();
        } else {
        }
    }
}
