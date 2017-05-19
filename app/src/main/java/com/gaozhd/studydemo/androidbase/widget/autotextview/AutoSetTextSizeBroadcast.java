package com.gaozhd.studydemo.androidbase.widget.autotextview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gaozhd.studydemo.utils.LogUtil;

/**
 * 自定义广播接受者
 *
 * @author zhd
 */
public class AutoSetTextSizeBroadcast extends BroadcastReceiver {

    /**
     * @title: AutoReceiver
     * @description: todo
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2017/5/18 0018 14:02
     */
    public interface AutoReceiver {
        public void onReceive();
    }

    private AutoReceiver mReceiver = null;

    public AutoSetTextSizeBroadcast() {

    }

    public AutoSetTextSizeBroadcast(AutoReceiver pReceiver) {
        mReceiver = pReceiver;
    }

    public void onReceive(Context arg0, Intent arg1) {
        if (mReceiver != null)
            mReceiver.onReceive();
    }

}
