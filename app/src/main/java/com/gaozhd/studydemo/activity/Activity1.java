package com.gaozhd.studydemo.activity;

import java.io.IOException;

import android.R.string;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.gaozhd.studydemo.R;

/**
 * 动态换肤
 * 
 * 1. http://blog.csdn.net/suiyc/article/details/6329212 2. 将 head 和 foot
 * 封装到一个Fragment当中，换肤是调用回调接口 3. broadcastRecever 提醒所有的Activity(BaseActivity)换肤
 * 
 * @author zhd
 * 
 */
public class Activity1 extends BaseActivity  {

	private ListView lvMain;
	private String[] allActivity;
	private ArrayAdapter<String> adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout0);
		init();
		setlvMainListener();
	}

	private void init() {
		lvMain = (ListView) findViewById(R.id.lvMain);
		allActivity = getResources().getStringArray(R.array.allghpf);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, allActivity);

		lvMain.setAdapter(adapter);
	}

	private void setlvMainListener() {
		lvMain.setOnItemClickListener(new OnItemClickListener() {

			Intent intent = new Intent();

			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				switch (position) {
				case 0:
					intent.setClass(Activity1.this, Activity1_item1.class);
					startActivity(intent);
					break;
				case 1:
					intent.setClass(Activity1.this, Activity1_item2.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			}
		});
	}

	
}
