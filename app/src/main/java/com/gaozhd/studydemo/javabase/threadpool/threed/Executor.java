/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 * <p/>
 * author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/

package com.gaozhd.studydemo.javabase.threadpool.threed;

import com.gaozhd.studydemo.GlobalInfoApplication;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Executor
 * @Description: ${todo}
 * @date 2016/10/17 15:40
 */
public abstract class Executor<T> implements Runnable, IExecutor<T> {

    @Override
    public void execute() {

        final T data = onExecute();

        GlobalInfoApplication.getInstance().getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onResponce(new ExecutorResponce(data));
            }
        });
    }

    @Override
    public void run() {
        execute();
    }
}
