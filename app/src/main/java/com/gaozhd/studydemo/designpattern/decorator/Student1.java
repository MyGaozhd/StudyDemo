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
public class Student1 extends Student {

    public Student1(StudentInterface studentInterface) {
        super(studentInterface);
    }

    private void sport() {
        Log.d("gaozhd", "努力运动！");
    }

    @Override
    public void study() {
        super.study();
        this.sport();
    }
}
