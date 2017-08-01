package com.gaozhd.studydemo.javabase.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @Description: ${todo}
 * @Date: 2017/7/14 0014 14:43
 */
public class TestReference {
    private String qiang;//强引用
    private SoftReference<String> ruo;//软引用
    private WeakReference<String> ruan;//弱引用
    private PhantomReference<String> xu;//虚引用

    public TestReference() {
Object l;
        qiang = new String("强");
        ruo = new SoftReference<String>(new String("软"));
        ruan = new WeakReference<String>(new String("弱"));
        xu = new PhantomReference<String>(new String(), new ReferenceQueue<String>());
    }
}
