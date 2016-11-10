package com.gaozhd.studydemo.designpattern.cloneable;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Money
 * @Description: 原型模式
 * @Date: 2016/11/10 19:37
 */
public class Money implements Cloneable {

    private int count;
    private String userName = "";

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    protected Money clone() {
        try {
            Money money = (Money) super.clone();
            money.count = this.count + 1;
            money.userName = this.userName;
            return money;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
