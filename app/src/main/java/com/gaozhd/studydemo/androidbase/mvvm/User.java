package com.gaozhd.studydemo.androidbase.mvvm;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: User
 * @Description: ${todo}
 * @date 2016/10/12 14:28
 */
public class User {

    private String name;
    private String sex;

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
