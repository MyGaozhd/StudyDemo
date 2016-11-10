
/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/

package com.gaozhd.studydemo.androidbase.rxjava;

import java.util.Vector;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RxManager
 * @Description: ${todo}
 * @Date 2016/11/8 15:32
 */
public class RxManager {

    /**
     * 单例对象
     */
    private static RxManager INSTANCE = null;

    /**
     * @title: RxManager
     * @description: 私有构造方法
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:02
     */
    private RxManager() {
    }

    /**
     * @title: getInstance
     * @description: 获得单例对象
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:09
     */
    public static RxManager getInstance() {
        if (INSTANCE == null) {
            synchronized (RxManager.class) {
                INSTANCE = new RxManager();
            }
        }
        return INSTANCE;
    }

    /**
     * 定义线程安全的subscription集合
     */
    private Vector<RxSubscription> subscriptions = null;

    /**
     * @title: removeSubscribe
     * @description: 取消订阅的方法
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:10
     */
    public void removeSubscribe(String tag) {

        if (subscriptions == null || tag == null) return;
        for (RxSubscription rs : subscriptions) {
            if (rs.checkToUnsubscribe(tag))
                subscriptions.remove(rs);
        }
    }

    /**
     * @title: addSubscribe
     * @description: 添加订阅的方法
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:11
     */
    public <T> void addSubscribe(String tag, RxObservable.RxCall<T> tc, RxSubscriber.RxNext<T> tn) {

        final RxSubscription rs = new RxSubscription(tag);
        rs.setSubscription(createSubscription(tc, tn, new RxSubscriber.RxCompleted() {
            @Override
            public void doCompleted() {
                subscriptions.remove(rs);
            }
        }));

        if (subscriptions == null)
            subscriptions = new Vector<>();
        subscriptions.add(rs);
    }

    /**
     * @title: createSubscription
     * @description: 创建Rxjava绑定对象
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:11
     */
    public <T> Subscription createSubscription(RxObservable.RxCall<T> rc, RxSubscriber.RxNext<T> rn, RxSubscriber.RxCompleted rm) {
        return RxObservable.create(rc).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscriber<T>(rn, rm));
    }
}
