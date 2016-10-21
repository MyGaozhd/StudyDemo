package com.gaozhd.studydemo.javabase.t.user.teacher;

import com.gaozhd.studydemo.javabase.t.user.BaseUser;
import com.gaozhd.studydemo.javabase.t.user.IUser;
import com.gaozhd.studydemo.javabase.t.user.User;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TeacherUser
 * @Description: ${todo}
 * @date 2016/10/16 13:58
 */
public class TeacherUser<T extends Teacher> extends User {

    public TeacherUser(T user) {
        super(user);
    }
}
