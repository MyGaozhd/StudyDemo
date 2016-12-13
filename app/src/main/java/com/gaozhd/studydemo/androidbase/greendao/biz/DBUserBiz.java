package com.gaozhd.studydemo.androidbase.greendao.biz;

import com.gaozhd.studydemo.androidbase.greendao.DBManager;
import com.gaozhd.studydemo.androidbase.greendao.dao.DBUserDao;
import com.gaozhd.studydemo.androidbase.greendao.entry.DBUser;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DBUserBiz
 * @Description: ${todo}
 * @date 2016/10/18 17:41
 */
public class DBUserBiz extends BaseBiz<DBUser, String> {

    private DBUserDao dbUserDao = null;

    public DBUserBiz() {
        dbUserDao = DBManager.getInstance().getDaoSession().getDBUserDao();
    }

//    public List<DBUser> getAllUserList() {
//        return getQueryBuilder().orderAsc(DBUserDao.Properties.Id).list();
//    }

    public DBUser getUserByID(String ID) {
        return getQueryBuilder().where(DBUserDao.Properties.Number.eq(ID)).unique();
    }

    @Override
    public AbstractDao getAbstractDao() {
        return dbUserDao;
    }
}
