package com.gaozhd.studydemo.androidbase.widget.dragview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DragActivity
 * @Description: ${todo}
 * @Date: 2017/6/5 0005 19:23
 */
public class DragActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wegit_dragview);
        ButterKnife.bind(this);
        tv.setOnTouchListener(new DragTouchListener(tv, this));
    }
}
