package com.gaozhd.studydemo.androidbase.layout;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LayoutActivity
 * @Description: ${todo}
 * @Date: 2017/6/11 0011 16:56
 */
public class LayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_layout);
        getWindow().setBackgroundDrawable(null);
    }
}
