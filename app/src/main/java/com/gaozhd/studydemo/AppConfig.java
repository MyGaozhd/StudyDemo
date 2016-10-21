

package com.gaozhd.studydemo;

import android.os.Environment;

public class AppConfig {


    /**
     * 数据库名称
     */
    public static final String DB_NAME = "studydemo.db";

    /**
     * 数据库是否加密
     */
    public static final boolean DB_ENCRYPTED = false;

    /**
     * 数据库名称（临时）
     */
    public final static String DB_NAME_TEMP = "studydemo.db";
    /**
     * 数据库版本（临时）
     */
    public final static int DB_VERSION_TEMP = 1;

    /**
     * 包名（临时）
     */
    public static final String PACKAGE_NAME_TEMP = "com.gaozhd.studydemo";
    /**
     * 手机里数据库存放路径（/data/data/com.tiantanhehe.yidonghuli/databases）（临时）
     */
    public static final String DB_PATH_TEMP = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME_TEMP + "/databases";


}
