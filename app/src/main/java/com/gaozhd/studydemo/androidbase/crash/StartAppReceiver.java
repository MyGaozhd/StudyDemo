package com.gaozhd.studydemo.androidbase.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartAppReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startActivity(context.getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName()));
    }

}
