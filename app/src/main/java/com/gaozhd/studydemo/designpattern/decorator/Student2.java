package com.gaozhd.studydemo.designpattern.decorator;

import android.util.Log;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class Student2 extends Student {

    public Student2(StudentInterface studentInterface) {
        super(studentInterface);
    }

    private void work() {
        Log.d("gaozhd", "努力工作！");
    }

    @Override
    public void study() {
        super.study();
        this.work();
    }
}
