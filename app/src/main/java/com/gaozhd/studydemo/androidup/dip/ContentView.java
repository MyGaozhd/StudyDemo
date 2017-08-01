package com.gaozhd.studydemo.androidup.dip;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ContentView
 * @Description: ${todo}
 * @Date: 2017/6/22 0022 16:47
 */
@Retention(RetentionPolicy.RUNTIME)//在什么时候用到
@Target(ElementType.TYPE)//用在什么上面
public @interface ContentView {
    int value();
}
