package com.gaozhd.studydemo.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.gaozhd.studydemo.R;

public class Activity4 extends BaseActivity {

	private TextView tv1;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout4);
		tv1 = (TextView) findViewById(R.id.textView1);

		Resources resources = this.getResources();
		int indentify = resources.getIdentifier(this.getPackageName() + ":xml/"
				+ "huxi", null, null);
		//resources.getIdentifier(name, defType, defPackage)
		if (R.xml.huxi == indentify) {
			tv1.setText("good");
		} else {
			tv1.setText("no good");
		}

	}

}
