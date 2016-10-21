package com.gaozhd.studydemo.javabase.t.user;

import com.gaozhd.studydemo.javabase.t.user.doctor.Doctor;
import com.gaozhd.studydemo.javabase.t.user.doctor.ManDoctor;
import com.gaozhd.studydemo.javabase.t.user.student.ManStudent;
import com.gaozhd.studydemo.javabase.t.user.student.Student;
import com.gaozhd.studydemo.javabase.t.user.student.StudentUser;
import com.gaozhd.studydemo.javabase.t.user.teacher.ManTeacher;
import com.gaozhd.studydemo.javabase.t.user.teacher.Teacher;
import com.gaozhd.studydemo.javabase.t.user.teacher.TeacherUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: Test
 * @Description: ${todo}
 * @date 2016/10/16 14:05
 */
public class Test {
    public static void test() {

        User<String> user = new User<>("gaozhd");

        TeacherUser<ManTeacher> teacherUser = new TeacherUser<>(new ManTeacher());

        List<? super BaseUser> list = new ArrayList<>();
        list.add(new ManDoctor());

//        List<? extends BaseUser> list1 = new ArrayList<>();
//        list1.add(new ManDoctor());
//        list1.add(new BaseUser());

        getUser(new User<ManTeacher>(new ManTeacher()));

        getTeacher(new User<BaseUser>(new ManTeacher()));
    }

    public static void getUser(User<? extends Teacher> user) {

    }

    public static <T> T getTeacher(User<? super Teacher> user) {

        return null;

    }

}
