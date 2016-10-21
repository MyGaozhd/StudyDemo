package com.gaozhd.studydemo.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.gaozhd.studydemo.R;

public class Activity2 extends BaseActivity {

	private Button btn;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		btn = (Button) findViewById(R.id.btn);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				showToast("当前时间" + SystemClock.currentThreadTimeMillis());
			}
		});
	}
}
