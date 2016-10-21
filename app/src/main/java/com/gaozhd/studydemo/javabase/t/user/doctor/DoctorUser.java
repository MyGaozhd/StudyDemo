package com.gaozhd.studydemo.javabase.t.user.doctor;

import com.gaozhd.studydemo.javabase.t.user.BaseUser;
import com.gaozhd.studydemo.javabase.t.user.User;
import com.gaozhd.studydemo.javabase.t.user.teacher.Teacher;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DoctorUser
 * @Description: ${todo}
 * @date 2016/10/16 13:55
 */
public class DoctorUser<T extends Doctor> extends User {

    public DoctorUser(T user) {
        super(user);
    }
}
