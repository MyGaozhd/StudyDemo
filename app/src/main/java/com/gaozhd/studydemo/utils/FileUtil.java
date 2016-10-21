package com.gaozhd.studydemo.utils;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FileUtil {
	/**
	 * 默认皮肤文件路径
	 */
	public static final String skinBasePath = "//data//data//cn.gaozhd.studydemo//skin//";

	/**
	 * 获取文件
	 * 
	 * @param url
	 * @return
	 */
	public static File getFile(String url) {
		File f = new File(url);
		return f;
	}

	/**
	 * 获取图片文件
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getBitMapFile(String fileName) {
		Bitmap bitmap = BitmapFactory.decodeFile(skinBasePath + fileName);
		return bitmap;
	}
}
