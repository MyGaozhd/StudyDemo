package com.gaozhd.studydemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

public class BaseActivity extends Activity {

	/**
	 * 上次提示信息的时间
	 */
	private long lastShowTime = 0;

	@Override
	protected void onResume() {

		super.onResume();

	}

	/**
	 * 提示信息
	 * 
	 * @param msg
	 *            要提示的信息
	 */
	public void showToast(String msg) {

		// 当前时间
		long nowTime = SystemClock.currentThreadTimeMillis();

		// 如果 当前时间-上次提示信息的时间 <4秒 时 不提示当前信息
		if (nowTime - lastShowTime > 4 * 1000) {
			Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

			// 设定上次提示时间为当前时间
			lastShowTime = nowTime;
		}
	}

}
