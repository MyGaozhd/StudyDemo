package com.gaozhd.studydemo.javabase.t.user.student;

import com.gaozhd.studydemo.javabase.t.user.User;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: StudentUser
 * @Description: ${todo}
 * @date 2016/10/16 13:47
 */
public class StudentUser<T extends Student> extends User {

    public StudentUser(T user) {
        super(user);
    }
}
