package com.gaozhd.studydemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Broadcast1 extends BroadcastReceiver {

	public interface onReceiver {
		public void onReceive();
	}

	private onReceiver mReceiver = null;

	public Broadcast1(onReceiver pReceiver) {
		mReceiver = pReceiver;
	}

	public void onReceive(Context arg0, Intent arg1) {
		mReceiver.onReceive();
	}

}
