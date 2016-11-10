package com.gaozhd.studydemo.androidbase.lifecycle.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LifeCycleActivity
 * @Description: ${todo}
 * @date 2016/11/2 19:18
 */
public class LifeCycleActivity4 extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.log("LifeCycleActivity4: " + "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lifycycle_activity0);
        ButterKnife.bind(this);
        tv.setBackgroundColor(Color.parseColor("#00ffff"));
        tv.setText("4");
        tv.setText("Activity :4" + " \nClassID:" + this.toString() + " \nTaskID:" + this.getTaskId());
    }

    @Override
    protected void onRestart() {
        LogUtil.log("LifeCycleActivity4: " + "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        LogUtil.log("LifeCycleActivity4: " + "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LogUtil.log("LifeCycleActivity4: " + "onResume");
        LogUtil.log("Activity :4" + " \nClassID:" + this.toString() + " \nTaskID:" + this.getTaskId());
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.log("LifeCycleActivity4: " + "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.log("LifeCycleActivity4: " + "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.log("LifeCycleActivity4: " + "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        LogUtil.log("LifeCycleActivity4: " + "onNewIntent");
        super.onNewIntent(intent);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn1:
                intent.setClass(LifeCycleActivity4.this, LifeCycleActivity1.class);
                break;
            case R.id.btn2:
                intent.setClass(LifeCycleActivity4.this, LifeCycleActivity2.class);
                break;
            case R.id.btn3:
                intent.setClass(LifeCycleActivity4.this, LifeCycleActivity4.class);
                break;
            case R.id.btn4:
                intent.setClass(LifeCycleActivity4.this, LifeCycleActivity4.class);
                break;
        }
        startActivity(intent);
    }
}
