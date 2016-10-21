package com.gaozhd.studydemo.designpattern.decorator;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class Student implements StudentInterface {

    private StudentInterface studentInterface;

    public Student(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    public void study() {
        studentInterface.study();
    }
}
