package com.gaozhd.studydemo.activity;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.adapter.GdhlAdapter;
import com.gaozhd.studydemo.tablefixheaders.TableFixHeaders;

import android.os.Bundle;

public class Activity5 extends BaseActivity {

	private TableFixHeaders lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout5);
		lv=(TableFixHeaders) findViewById(R.id.table);
		lv.setAdapter(new GdhlAdapter(this));
	}
}
