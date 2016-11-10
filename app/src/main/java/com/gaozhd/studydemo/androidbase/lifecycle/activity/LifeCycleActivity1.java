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
public class LifeCycleActivity1 extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.log("LifeCycleActivity1: " + "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lifycycle_activity0);
        ButterKnife.bind(this);
        tv.setBackgroundColor(Color.parseColor("#ff0000"));
        LogUtil.log(tv.getText().toString());
        tv.setText("1");

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                tv.setText("1");
//                LogUtil.log(tv.getText().toString());
//            }
//        }).start();
////        tv.setText("1");
//        tv.setText("Activity :1" + " \nClassID:" + this.toString() + " \nTaskID:" + this.getTaskId());
    }

    @Override
    protected void onRestart() {

        LogUtil.log("LifeCycleActivity1: " + "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {



        LogUtil.log("LifeCycleActivity1: " + "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LogUtil.log("LifeCycleActivity1: " + "onResume");
        LogUtil.log("Activity :1" + " \nClassID:" + this.toString() + " \nTaskID:" + this.getTaskId());
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.log("LifeCycleActivity1: " + "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.log("LifeCycleActivity1: " + "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.log("LifeCycleActivity1: " + "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        LogUtil.log("LifeCycleActivity1: " + "onNewIntent");
        super.onNewIntent(intent);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn1:
                intent.setClass(LifeCycleActivity1.this, LifeCycleActivity1.class);
                break;
            case R.id.btn2:
                intent.setClass(LifeCycleActivity1.this, LifeCycleActivity2.class);
                break;
            case R.id.btn3:
                intent.setClass(LifeCycleActivity1.this, LifeCycleActivity3.class);
                break;
            case R.id.btn4:
                intent.setClass(LifeCycleActivity1.this, LifeCycleActivity4.class);
                break;
        }
        startActivity(intent);
    }
}
