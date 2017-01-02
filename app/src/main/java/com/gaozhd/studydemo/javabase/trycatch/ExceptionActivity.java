package com.gaozhd.studydemo.javabase.trycatch;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.androidbase.mvvm.User;
import com.gaozhd.studydemo.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ExceptionActivity
 * @Description: ${todo}
 * @Date: 2017/1/1 0001 21:04
 */
public class ExceptionActivity extends BaseActivity {
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_exception);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onClick() {
        test1();
        try {
            test2();
        } catch (ExceptionA exceptionA) {
            LogUtil.log("ExceptionA: onClick");
            exceptionA.printStackTrace();
        }

        LogUtil.log("test3: " + test3() + "");

        LogUtil.log("test4: " + test4().getName() + "");

        LogUtil.log("test5: " + test5() + "");

        LogUtil.log("test6: " + test6() + "");
    }

    private void test1() {
        LogUtil.log("\n");
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA a) {
                LogUtil.log("ExceptionA");
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log("ExceptionB");
            return;
        } finally {
            LogUtil.log("finally");
        }
    }

    private void test2() throws ExceptionA {
        LogUtil.log("\n");
        try {
            try {
                throw new ExceptionA();
            } catch (ExceptionA a) {
                LogUtil.log("ExceptionA");
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log("ExceptionB");
            return;
        } finally {
            LogUtil.log("finally");
        }
    }

    private int test3() {
        LogUtil.log("\n");
        int i = 0;
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA a) {
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log(i + "");
            return i;
        } finally {
            i = 2;

        }
    }

    private User test4() {
        LogUtil.log("\n");
        User user = new User("gaozhd", "男");
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA a) {
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log("name:" + user.getName() + "");
            return user;
        } finally {
            user.setName("servi");
        }
    }

    private Integer test5() {
        LogUtil.log("\n");
        Integer i = new Integer(16654789);
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA a) {
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log(i + "");
            LogUtil.log(i.hashCode());
            return i;
        } finally {
            i = new Integer(225489489);
            LogUtil.log(i.hashCode());
        }
    }

    private Integer test6() {
        LogUtil.log("\n");
        Integer i = new Integer(1665554789);
        try {
            try {
                throw new ExceptionB();
            } catch (ExceptionA a) {
                throw a;
            }
        } catch (ExceptionB exceptionB) {
            LogUtil.log(i + "");
            LogUtil.log(i.hashCode());
            return i;
        } finally {
            i = 225489489;
            LogUtil.log(i.hashCode());
        }
    }
}
