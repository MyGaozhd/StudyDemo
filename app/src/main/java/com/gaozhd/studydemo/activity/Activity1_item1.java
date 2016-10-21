package com.gaozhd.studydemo.activity;

import java.io.IOException;

import android.R.string;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.broadcast.Broadcast1;

/**
 * 动态换肤
 * 
 * 1. http://blog.csdn.net/suiyc/article/details/6329212 2. 将 head 和 foot
 * 封装到一个Fragment当中，换肤是调用回调接口 3. broadcastRecever 提醒所有的Activity(BaseActivity)换肤
 * 
 * 
 * 当前方法时将皮肤文件放置在assets文件夹中
 * 
 * @author zhd
 * 
 */
public class Activity1_item1 extends Activity1_BaseActivity implements
		OnClickListener {

	/**
	 * 点击直接切换皮肤
	 */
	private Button btn1;
	/**
	 * 发送广播
	 */
	private Button btn2;
	/**
	 * 启动下一个Activity
	 */
	private Button btn3;

	private ImageView iv;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout1);

		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);

		iv = (ImageView) findViewById(R.id.iv);
	}

	private String fileName = "skin1.jpg";

	public void onClick(View arg0) {

		switch (arg0.getId()) {
		case R.id.btn1:
			changePf();
			break;
		case R.id.btn2:
			Intent intent = new Intent(Activity1_item1.this, Broadcast1.class);
			sendBroadcast(intent);
			break;
		case R.id.btn3:
			Intent intent1 = new Intent(Activity1_item1.this,
					Activity1_item2.class);
			startActivity(intent1);
			break;
		default:
			break;
		}

	}

	@Override
	public void changePf() {
		try {
			iv.setImageBitmap(BitmapFactory.decodeStream(Activity1_item1.this
					.getAssets().open(fileName)));
			if (fileName.equals("skin1.jpg")) {
				fileName = "skin2.jpg";
			} else {
				fileName = "skin1.jpg";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
