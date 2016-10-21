package com.gaozhd.studydemo.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gaozhd.studydemo.R;

/**
 * 日期选择控件
 * 
 * @author Administrator
 * 
 */
public class Activity3 extends BaseActivity {

	private DatePicker datePicker;
	private TimePicker timePicker;

	private TextView tv;

	/**
	 * 日期格式字符串yyyy-MM-dd HH:mm:ss.
	 */
	public static final String YYYY_MM_DDDD_HH24_MI_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式字符串yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String YYYY_MM_DDDD_HH24_MI_SS_S = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * 日期格式字符串yyyy-MM-dd HH:mm:ss.
	 */
	public static final String YYYY_MM_DDDD_HH24_MI = "yyyy-MM-dd HH:mm";

	/**
	 * 日期格式字符串MM-dd HH:mm.
	 */
	public static final String MM_DDDD_HH24_MI = "MM-dd HH:mm";

	/**
	 * 日期格式字符串yyyy-MM-dd.
	 */
	public static final String YYYY_MM_DDDD = "yyyy-MM-dd";
	/**
	 * 日期格式字符串yyyy年MM月dd日.
	 */
	public static final String YYYY_MM_DDDD_CN = "yyyy年MM月dd日";

	/**
	 * 日期格式字符串yyyy年MM月dd日.
	 */
	public static final String YYYY_MM_CN = "yyyy年MM月";

	/**
	 * 日期格式字符串yyyy年MM月dd日.
	 */
	public static final String YYYY_M_D_CN = "yyyy年M月d日";

	/** 日期格式字符串yyyy-MM */
	public static final String YYYY_MM = "yyyy-MM";

	/** 日期格式字符串yyyyMM */
	public static final String YYYYMM = "yyyyMM";

	/** 日期格式字符串yyMM */
	public static final String YYMM = "yyMM";

	/**
	 * 日期格式字符串yyyyMMdd.
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
	/**
	 * 日期格式字符串yyMMdd.
	 */
	public static final String YYMMDD = "yyMMdd";

	/**
	 * 日期格式字符串HH:mm
	 */
	public static final String HHMM = "HH:mm";

	/**
	 * 日期格式字符串HH:mm:ss
	 */
	public static final String HH_MM_SS = "HH:mm:ss";

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout3);
		datePicker = (DatePicker) findViewById(R.id.datePicker1);
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
		tv = (TextView) findViewById(R.id.tv);

		((ViewGroup) ((ViewGroup) this.datePicker.getChildAt(0)).getChildAt(0))
				.getChildAt(0).setBackgroundColor(Color.RED);

		((ViewGroup) ((ViewGroup) this.datePicker.getChildAt(0)).getChildAt(0))
				.getChildAt(1).setBackgroundColor(Color.GREEN);

		((ViewGroup) ((ViewGroup) this.datePicker.getChildAt(0)).getChildAt(0))
				.getChildAt(2).setBackgroundColor(Color.BLUE);

		((ViewGroup) ((ViewGroup) this.timePicker.getChildAt(0)).getChildAt(0))
				.getChildAt(0).setBackgroundColor(Color.RED);

		((ViewGroup) ((ViewGroup) this.timePicker.getChildAt(0)).getChildAt(0))
				.getChildAt(1).setBackgroundColor(Color.GREEN);
		((ViewGroup) this.timePicker.getChildAt(0)).getChildAt(1)
				.setBackgroundColor(Color.BLUE);

		// ((ViewGroup) ((ViewGroup)
		// this.timePicker.getChildAt(0)).getChildAt(0))
		// .getChildAt(2).setBackgroundColor(Color.BLUE);

		// ((ViewGroup) ((ViewGroup)
		// this.datePicker.getChildAt(0)).getChildAt(0))
		// .getChildAt(2).setVisibility(View.GONE);
		// ((ViewGroup) this.datePicker.getChildAt(0)).

		// 获得日历实例
		Calendar calendar = Calendar.getInstance();

		calendar.set(datePicker.getYear(), datePicker.getMonth(),
				datePicker.getDayOfMonth(), timePicker.getCurrentHour(),
				timePicker.getCurrentMinute());

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");

		String dateTime = sdf1.format(calendar.getTime());

		dateTime += "\n";

		SimpleDateFormat sdf2 = new SimpleDateFormat(YYYY_MM_DDDD_HH24_MI_SS);

		dateTime += sdf2.format(calendar.getTime());
		dateTime += "\n";

		SimpleDateFormat sdf3 = new SimpleDateFormat(YYYY_MM_DDDD_HH24_MI_SS_S);

		dateTime += sdf3.format(calendar.getTime());
		dateTime += "\n";

		SimpleDateFormat sdf4 = new SimpleDateFormat(YYYY_MM_DDDD_CN);

		dateTime += sdf4.format(calendar.getTime());
		dateTime += "\n";

		SimpleDateFormat sdf5 = new SimpleDateFormat(YYYYMMDD);

		dateTime += sdf5.format(calendar.getTime());

		dateTime += "\n";

		SimpleDateFormat sdf6 = new SimpleDateFormat(YYMMDD);

		dateTime += sdf6.format(calendar.getTime());
		dateTime += "\n";

		tv.setText(dateTime);
	}
}
