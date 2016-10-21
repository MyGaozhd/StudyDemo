/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 *  author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/

package com.gaozhd.studydemo.javabase.threadpool.threed;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: IExecutor
 * @Description: ${todo}
 * @date 2016/10/17 15:08
 */
public interface IExecutor<T> {

    /**
     * @Title: execute
     * @Description: 执行方法
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/17 15:12
     */
    public void execute();

    public T onExecute();

    public void onResponce(ExecutorResponce<T> data);
}
