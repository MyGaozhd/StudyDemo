package com.gaozhd.suanfa.views.stack;

import com.gaozhd.gkit.common.util.LogUtil;

import java.util.Stack;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Stack2
 * @Description: ${todo}
 * @Date: 2017/8/4 0004 15:18
 */
public class Stack2 {
    private Stack<Integer> olds = new Stack<>();
    private Stack<Integer> news = new Stack<>();

    public Stack2() {
        olds.push(1);
        olds.push(1);
        olds.push(0);
        olds.push(4);
        olds.push(3);
        olds.push(2);

        sort();
    }

    private void sort() {
        Integer value;
        while (!olds.isEmpty()) {
            value = olds.pop();
            if (news.isEmpty()) {
                news.push(value);
            } else if (!news.isEmpty()) {
                if (news.peek() >= value) {
                    news.push(value);
                } else {
                    while (!news.isEmpty() && news.peek() < value) {
                        olds.push(news.pop());
                    }
                    news.push(value);
                }
            }
        }

        LogUtil.logJson(news);
    }
}
