package com.gaozhd.studydemo.androidbase.widget.autotextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: AutoTextViewActivity
 * @Description: ${todo}
 * @Date: 2017/5/18 0018 10:30
 */
public class AutoTextViewActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;
    private float textSize = 12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_autotextview);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        textSize += 10;
        SharedPreferencesUtils.setParam(this, "textsize", textSize);
        Intent intent = new Intent(AutoSetTextSizeView.ACTION);
        sendBroadcast(intent);
    }
}
