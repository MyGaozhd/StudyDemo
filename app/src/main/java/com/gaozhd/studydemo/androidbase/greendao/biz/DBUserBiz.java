package com.gaozhd.studydemo.androidbase.greendao.biz;

import android.content.Context;

import com.gaozhd.studydemo.androidbase.greendao.DBManager;
import com.gaozhd.studydemo.androidbase.greendao.dao.DBUserDao;
import com.gaozhd.studydemo.androidbase.greendao.dao.DaoSession;
import com.gaozhd.studydemo.androidbase.greendao.entry.DBUser;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DBUserBiz
 * @Description: ${todo}
 * @date 2016/10/18 17:41
 */
public class DBUserBiz {

    private DBUserDao dbUserDao = null;
    private QueryBuilder<DBUser> dbUserQueryBuilder = null;

    public DBUserBiz(Context context) {
        DBManager dbManager = DBManager.getInstance(context);
        DaoSession daoSession = dbManager.getDaoSession();

        dbUserDao = daoSession.getDBUserDao();
        dbUserQueryBuilder = dbUserDao.queryBuilder();
    }

    public List<DBUser> getAllUserList() {
        return dbUserQueryBuilder.orderAsc(DBUserDao.Properties.Id).list();
    }

    public DBUser getUserByID(String ID) {
        return dbUserQueryBuilder.where(DBUserDao.Properties.Number.eq(ID)).unique();
    }
}
