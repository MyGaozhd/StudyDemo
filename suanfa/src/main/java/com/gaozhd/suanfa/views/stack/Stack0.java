package com.gaozhd.suanfa.views.stack;

import com.gaozhd.gkit.common.util.LogUtil;

import java.util.Stack;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Stack0
 * @Description: ${todo}
 * @Date: 2017/8/2 0002 15:44
 */
public class Stack0 {
    private Stack<Integer> stack;

    public Stack0() {
        stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        LogUtil.log(stack);
        reverse(stack);
    }

    private void reverse(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty())
            return;

        Integer i = getEndItem(stack);
        reverse(stack);
        stack.push(i);
        LogUtil.log(stack);
    }

    private Integer getEndItem(Stack<Integer> stack) {
        LogUtil.log(stack.size());
        Integer i = stack.pop();
        if (stack.isEmpty()) {
            return i;
        } else {
            Integer j = getEndItem(stack);
            stack.push(i);
            LogUtil.log(stack);
            return j;
        }
    }
}
