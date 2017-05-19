package com.gaozhd.studydemo.javabase.multithread.lock;

import com.gaozhd.studydemo.activity.BaseActivity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LockActivity
 * @Description: ${todo}
 * @Date: 2017/5/5 0005 8:08
 */
public class LockActivity extends BaseActivity {
    private Lock lock = new ReentrantLock();

}
