package com.gaozhd.studydemo.androidbase.greendao.biz;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: BaseBiz
 * @Description: ${todo}
 * @Date: 2016/11/16 13:41
 */
public abstract class BaseBiz<M, K> implements IBiz<M, K> {




    /**
     * @title AbstractDao
     * @description: 获得操作Dao
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/20 20:25
     */
    public abstract AbstractDao<M, K> getAbstractDao();

    @Override
    public boolean insert(@NonNull M m) {
        try {
            if (m == null)
                return false;
            getAbstractDao().insert(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplace(@NonNull M m) {
        try {
            if (m == null)
                return false;
            getAbstractDao().insertOrReplace(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(@NonNull M m) {
        try {
            if (m == null)
                return false;
            getAbstractDao().delete(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByKey(K key) {
        try {
            if (key == null)
                return false;
            getAbstractDao().deleteByKey(key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByKeyInTx(K... key) {
        try {
            if (key == null || key.length <= 0)
                return false;
            getAbstractDao().deleteByKeyInTx(key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteList(List<M> mList) {
        try {
            if (mList == null || mList.size() == 0)
                return false;
            getAbstractDao().deleteInTx(mList);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        try {
            getAbstractDao().deleteAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(@NonNull M m) {
        try {
            if (m == null)
                return false;
            getAbstractDao().update(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInTx(M... m) {
        try {
            if (m == null)
                return false;
            getAbstractDao().updateInTx(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateList(List<M> mList) {
        try {
            if (mList == null || mList.size() == 0)
                return false;
            getAbstractDao().updateInTx(mList);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public M selectByPrimaryKey(@NonNull K key) {
        try {
            return getAbstractDao().load(key);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<M> loadAll() {
        return getAbstractDao().loadAll();
    }

    @Override
    public boolean refresh(@NonNull M m) {
        try {
            if (m == null)
                return false;

            getAbstractDao().refresh(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void runInTx(Runnable runnable) {
//        try {            
//            daoSession.runInTx(runnable);
//        } catch (Exception e) {
//        }
    }

    @Override
    public boolean insertList(@NonNull List<M> list) {
        try {
            if (list == null || list.size() == 0)
                return false;
            getAbstractDao().insertInTx(list);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean insertOrReplaceList(@NonNull List<M> list) {
        try {
            if (list == null || list.size() == 0)
                return false;
            getAbstractDao().insertOrReplaceInTx(list);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public QueryBuilder<M> getQueryBuilder() {
        return getAbstractDao().queryBuilder();
    }

    /**
     * @param where
     * @param selectionArg
     * @return
     */
    @Override
    public List<M> queryRaw(String where, String... selectionArg) {

        return getAbstractDao().queryRaw(where, selectionArg);
    }

    public Query<M> queryRawCreate(String where, Object... selectionArg) {

        return getAbstractDao().queryRawCreate(where, selectionArg);
    }

    public Query<M> queryRawCreateListArgs(String where, Collection<Object> selectionArg) {

        return getAbstractDao().queryRawCreateListArgs(where, selectionArg);
    }

    @Override
    public void clearDaoSession() {

    }

    @Override
    public boolean dropDatabase() {
        return false;
    }
}
