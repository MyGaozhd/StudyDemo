package com.gaozhd.studydemo.activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.gaozhd.studydemo.R;

/**
 * 广播接收者
 * 
 * @author zhd
 * 
 */
public class Activity0 extends BaseActivity {

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
		allActivity = getResources().getStringArray(R.array.allBroadcast);
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
					intent.setClass(Activity0.this, Activity0_item1.class);
					startActivity(intent);
					break;

				default:
					break;
				}
			}
		});
	}
}
