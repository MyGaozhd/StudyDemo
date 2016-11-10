/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/
package com.gaozhd.studydemo.androidbase.rxjava;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.plugins.RxJavaPlugins;

/**
 * @Author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RxObservable
 * @Description: Rxjava被观察者对象
 * @Date 2016/11/8 17:06
 */
public class RxObservable<T> extends Observable<T> {

    private RxObservable(OnSubscribe<T> f) {
        super(f);
    }

    public interface RxCall<T> {
        T call();
    }

    /**
     * @title: create
     * @description: 创建观察者对象
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/11/8 17:47
     */
    public static <T> RxObservable<T> create(final RxCall<T> rxCall) {
        return new RxObservable<T>(RxJavaPlugins.getInstance().getObservableExecutionHook().onCreate(
                new OnSubscribe<T>() {
                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        T t = rxCall.call();
                        subscriber.onNext(t);
                        subscriber.onCompleted();
                    }
                }));
    }

    /**
     * @title: create
     * @description: create回调的集合方法  暂时没用
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2016/11/8 20:15
     */
    public static <T> RxObservable<T> create(final List<RxCall<T>> rxCalls) {
        return new RxObservable<T>(RxJavaPlugins.getInstance().getObservableExecutionHook().onCreate(
                new OnSubscribe<T>() {
                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        for (RxCall<T> rx : rxCalls) {
                            subscriber.onNext(rx.call());
                        }
                        subscriber.onCompleted();
                    }
                }));
    }


}
