package com.gaozhd.studydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.broadcast.Broadcast0;

/**
 * 广播接收者
 * 
 * @author zhd
 * 
 */
public class Activity0_item1 extends BaseActivity implements OnClickListener {

	private Button btn1;
	private TextView tv;
	private Broadcast0 mBroadcast0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout0_item1);

		mBroadcast0 = new Broadcast0(new Broadcast0.onReceiver() {

			@Override
			public void onReceive() {
				tv.setText("123456789");
			}
		});

		btn1 = (Button) findViewById(R.id.btn1);
		tv = (TextView) findViewById(R.id.tv);

		btn1.setOnClickListener(this);
	}

	private void send1() {
		Intent intent = new Intent(this, Broadcast0.class);
		sendBroadcast(intent);
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {

		case R.id.btn1:
			send1();
			break;

		default:
			break;
		}
	}

}
