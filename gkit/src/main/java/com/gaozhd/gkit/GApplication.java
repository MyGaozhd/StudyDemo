package com.gaozhd.gkit;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: GApplication
 * @Description: ${todo}
 * @Date: 2017/8/2 0002 16:19
 */
public class GApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    /**
     * @title: isDebug
     * @description: 判断是否为debug模式
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2017/7/27 0027 15:55
     */
    private boolean isDebug() {
        ApplicationInfo info = getApplicationInfo();
        return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }
}
