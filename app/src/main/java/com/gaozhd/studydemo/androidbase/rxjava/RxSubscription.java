/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/
package com.gaozhd.studydemo.androidbase.rxjava;

import rx.Subscription;

/**
 * @Author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RxSubscription
 * @Description: 取消绑定类型
 * @Date 2016/11/8 15:49
 */
public class RxSubscription {

    /**
     * 默认请求的Tag
     */
    private String Tag = "Tag";
    /**
     * Subscription
     */
    private Subscription subscription;

    public RxSubscription(String tag) {
        this.Tag = tag;
    }

    public RxSubscription(String tag, Subscription subscription) {
        this.Tag = tag;
        this.subscription = subscription;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * @title: checkToUnsubscribe
     * @description: check是否需要取消绑定
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/11/8 1:59
     */
    public boolean checkToUnsubscribe(String tag) {
        if (getTag().equals(tag)) {
            getSubscription().unsubscribe();
            return true;
        }
        return false;
    }
}
