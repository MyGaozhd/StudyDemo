package com.gaozhd.studydemo.androidup.leakheap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LeakHeapActivity
 * @Description: ${todo}
 * @Date: 2017/6/20 0020 16:04
 */
public class LeakHeapActivity extends BaseActivity {

    private static View view = null;
    private static LeakHeapActivity activity = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    private static InnerClass innerClass = null;
    private static View.OnClickListener clickListener = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_leak_heap);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                view = findViewById(R.id.button1);
                break;
            case R.id.button2:
                activity = LeakHeapActivity.this;
                break;
            case R.id.button3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LeakHeapActivity.this, "123", Toast.LENGTH_SHORT).show();
                    }
                }, 5 * 1000);
                break;
            case R.id.button4:

                break;
            case R.id.button5:
                innerClass = new InnerClass();
                clickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                };
                break;
        }
    }

   static class InnerClass {

    }
}
