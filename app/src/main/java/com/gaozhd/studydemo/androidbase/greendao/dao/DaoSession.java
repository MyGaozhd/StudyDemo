package com.gaozhd.studydemo.androidbase.greendao.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.gaozhd.studydemo.androidbase.greendao.entry.DBUser;

import com.gaozhd.studydemo.androidbase.greendao.dao.DBUserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dBUserDaoConfig;

    private final DBUserDao dBUserDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dBUserDaoConfig = daoConfigMap.get(DBUserDao.class).clone();
        dBUserDaoConfig.initIdentityScope(type);

        dBUserDao = new DBUserDao(dBUserDaoConfig, this);

        registerDao(DBUser.class, dBUserDao);
    }
    
    public void clear() {
        dBUserDaoConfig.clearIdentityScope();
    }

    public DBUserDao getDBUserDao() {
        return dBUserDao;
    }

}