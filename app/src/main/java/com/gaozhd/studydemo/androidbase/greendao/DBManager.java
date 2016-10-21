
package com.gaozhd.studydemo.androidbase.greendao;

import android.content.Context;

import com.gaozhd.studydemo.AppConfig;
import com.gaozhd.studydemo.androidbase.greendao.dao.DaoMaster;
import com.gaozhd.studydemo.androidbase.greendao.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class DBManager {

    private static boolean ENCRYPTED = AppConfig.DB_ENCRYPTED;

    private static String DB_NAME = AppConfig.DB_NAME;

    private static DBManager mInstance;
    private DaoSession mDaoSession;
    private Context mContext;

    public DBManager(Context context) {
        this.mContext = context;
        DaoMaster.DevOpenHelper mDevOpenHelper = new DaoMaster.DevOpenHelper(context, ENCRYPTED ? DB_NAME+"-encrypted" : DB_NAME);
        Database db = ENCRYPTED ? mDevOpenHelper.getEncryptedWritableDb("super-secret") : mDevOpenHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
