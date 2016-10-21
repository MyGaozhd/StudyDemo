package com.gaozhd.studydemo.javabase.t.user;

import com.gaozhd.studydemo.javabase.t.user.teacher.Teacher;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: User
 * @Description: ${todo}
 * @date 2016/10/16 14:00
 */
public class User<T> implements IUser {

    private T user;

    public User(T user) {
        this.user = user;
    }

    @Override
    public T getUser() {
        return user;
    }
}
