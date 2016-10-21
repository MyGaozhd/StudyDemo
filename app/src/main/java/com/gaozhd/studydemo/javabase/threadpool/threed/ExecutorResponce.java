/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 *  author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/

package com.gaozhd.studydemo.javabase.threadpool.threed;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ExecutorResponce
 * @Description: ${todo}
 * @date 2016/10/17 15:49
 */
public class ExecutorResponce<T> {

    private T data;

    public ExecutorResponce(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
