package com.gaozhd.studydemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 自定义广播接受者
 * 
 * @author zhd
 * 
 */
public class Broadcast0 extends BroadcastReceiver {

	public interface onReceiver {
		public void onReceive();
	}

	private onReceiver mReceiver = null;

	public Broadcast0(){}
	public Broadcast0(onReceiver pReceiver) {
		mReceiver = pReceiver;
	}

	public void onReceive(Context arg0, Intent arg1) {
		mReceiver.onReceive();
	}

}
