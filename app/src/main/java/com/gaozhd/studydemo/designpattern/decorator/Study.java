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
public class Study implements StudentInterface {

    @Override
    public void study() {
        Log.d("gaozhd", "努力学习！");
    }
}
