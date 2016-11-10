/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/
package com.gaozhd.studydemo.androidbase.rxjava;

import rx.Subscriber;

/**
 * @Author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RxSubscriber
 * @Description: RxSubscriber 观察者对象执行的回调接口
 * @Date 2016/11/8 15:33
 */
public class RxSubscriber<T> extends Subscriber<T> {

    private RxNext<T> rxNext = null;
    private RxCompleted rxCompleted = null;

    public RxSubscriber(RxNext<T> rxNext) {
        this.rxNext = rxNext;
    }

    public RxSubscriber(RxNext<T> rxNext, RxCompleted rxCompleted) {
        this.rxNext = rxNext;
        this.rxCompleted = rxCompleted;
    }

    public interface RxNext<T> {
        void doNext(T data);
    }

    public interface RxCompleted {
        void doCompleted();
    }

    @Override
    public void onCompleted() {
        if (rxCompleted != null)
            rxCompleted.doCompleted();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {
        if (rxNext != null)
            rxNext.doNext(t);
    }
}
