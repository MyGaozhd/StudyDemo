package com.gaozhd.studydemo.androidbase.touch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.LogUtil;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TouchActivity
 * @Description: ${todo}
 * @Date: 2017/2/14 0014 19:34
 */
public class TouchActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_touch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.log(" TouchActivity : dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.log(" TouchActivity : onTouchEvent");
        return super.onTouchEvent(event);
    }
}
