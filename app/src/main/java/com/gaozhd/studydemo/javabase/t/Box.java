package com.gaozhd.studydemo.javabase.t;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Box
 * @Description: ${todo}
 * @date 2016/10/16 12:04
 */
public class Box<T> {

    private T data;

    public Box() {
    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
