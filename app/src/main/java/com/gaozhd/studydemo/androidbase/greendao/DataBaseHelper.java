/*
 * Copyright (c) 2011-3011 天坦软件
 */

package com.gaozhd.studydemo.androidbase.greendao;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.gaozhd.studydemo.AppConfig;
import com.gaozhd.studydemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataBaseHelper extends SQLiteOpenHelper {

	/**
	 * 日志标签
	 */
	private static final String LOG_TAG = "DataBaseHelper";
	/**
	 * 缓冲区大小
	 */
	private static final int BUFFER_SIZE = 2048;

	/**
	 * Constructor
	 * 
	 * @param context
	 *            Application context
	 */
	public DataBaseHelper(Context context) {
		super(context, AppConfig.DB_NAME, null, AppConfig.DB_VERSION_TEMP);
	}

	/*
	 * 
	 * 
	 * @param db
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase)
	 */

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	/*
	 * 
	 * 
	 * @param db
	 * 
	 * @param oldVersion
	 * 
	 * @param newVersion
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
	 * .SQLiteDatabase, int, int)
	 */

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @Title: createDataBase
	 * @Description: 导入静态数据库
	 * @param: @param context
	 * @return: void
	 * @throws
	 */
	public void createDataBase(Context context) {
		try {
			File dbDir = new File(AppConfig.DB_PATH_TEMP);
			// 如果不存在该目录则创建
			if (!dbDir.exists()) {
				dbDir.mkdir();
			}
			// 打开静态数据库文件的输入流
			InputStream is = context.getResources().openRawResource(R.raw.studydemo);
			// 打开目标数据库文件的输出流
			FileOutputStream os = new FileOutputStream(AppConfig.DB_PATH_TEMP + "/"
					+ AppConfig.DB_NAME);
			byte[] buffer = new byte[BUFFER_SIZE];
			int count = 0;
			// 将静态数据库文件拷贝到目的地
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			Log.e(LOG_TAG, "FileNotFoundException");
			e.printStackTrace();
		} catch (NotFoundException e) {
			Log.e(LOG_TAG, "NotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(LOG_TAG, "IOException");
			e.printStackTrace();
		}
	}
}
