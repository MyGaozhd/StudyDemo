package com.gaozhd.studydemo.androidup.dip;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ViewInject
 * @Description: ${todo}
 * @Date: 2017/6/22 0022 17:01
 */
@Retention(RetentionPolicy.RUNTIME)//时间
@Target(ElementType.FIELD)//位置 属性上面
public @interface ViewInject {
    int value();
}
