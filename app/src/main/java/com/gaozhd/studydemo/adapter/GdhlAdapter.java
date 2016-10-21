package com.gaozhd.studydemo.adapter;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.tablefixheaders.BaseTableAdapter;


public class GdhlAdapter extends BaseTableAdapter {

	private final static int WIDTH_DIP = 110 * 2;
	private final static int HEIGHT_DIP = 32;

	private final int width;
	private final int height;

	private Context mContext;

	public GdhlAdapter(Context pContext) {
		mContext = pContext;

		width = Math.round(TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, WIDTH_DIP, mContext.getResources()
						.getDisplayMetrics()));
		height = Math.round(TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, HEIGHT_DIP, mContext
						.getResources().getDisplayMetrics()));
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public View getView(int row, int column, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.layout5_item1, null);

		Log.d("gaozhd", "row: " + row + "col:" + column);
		return view;
	}

	@Override
	public int getWidth(int column) {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight(int row) {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getItemViewType(int row, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getViewTypeCount() {

		return 1;
	}

}
