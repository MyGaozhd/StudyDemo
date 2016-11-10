/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/
package com.gaozhd.studydemo.androidbase.rxjava;

/**
 * @Author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RxProsenter
 * @Description: MVP方式中用于清除本次请求
 * @Date 2016/11/8 15:47
 */
public abstract class RxProsenter {
    public RxProsenter() {
    }

    public abstract void onDestroy();
}
