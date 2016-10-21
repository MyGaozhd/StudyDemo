
/*******************************************************************************
 * Copyright (c) 2011-3011 天坦软件
 *
 *  author Gao Zhidong <gaozhidong@tiantanhehe.com>
 ******************************************************************************/

package com.gaozhd.studydemo.javabase.threadpool.threed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ExecutorTool
 * @Description: ${todo}
 * @date 2016/10/17 15:03
 */
public class ExecutorTool {

    private static ExecutorTool tool = null;
    private ExecutorService executorService = null;

    /**
     * @Title: ExecutorTool
     * @Description: 构造方法
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/17 15:16
     */
    private ExecutorTool() {
        //创建一个线程池
        executorService = Executors.newCachedThreadPool();
    }

    /**
     * @Title: getInstance
     * @Description: 单例方法
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/17 15:11
     */
    public static ExecutorTool getInstance() {

        if (tool == null) {
            tool = new ExecutorTool();
        }
        return tool;
    }

    /**
     * @Title: execute
     * @Description: 执行
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/17 15:42
     */
    public void execute(Executor e) {
        executorService.execute(e);
    }
}
