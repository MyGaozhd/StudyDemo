package com.gaozhd.studydemo;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import com.gaozhd.studydemo.androidbase.crash.RebootThreadExceptionHandler;
import com.gaozhd.studydemo.androidbase.greendao.DataBaseHelper;
import com.gaozhd.studydemo.utils.SystemUtil;
import com.gaozhd.studydemo.utils.storage.StorageUtil;
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

        StorageUtil.init(this, null);

        if (SystemUtil.inMainProcess(this)) {
            //leakcanary初始化
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return;
            }
            LeakCanary.install(this);

//            // 程序异常关闭1s之后重新启动
//            RebootThreadExceptionHandler.getInstance(getBaseContext());
        }

    }
}
