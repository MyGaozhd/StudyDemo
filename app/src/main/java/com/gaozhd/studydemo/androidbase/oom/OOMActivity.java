package com.gaozhd.studydemo.androidbase.oom;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: OOMActivity
 * @Description: ${todo}
 * @date 2016/11/2 19:00
 */
public class OOMActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oom1);
        ButterKnife.bind(this);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("123456789");
            }
        }, 3 * 60 * 1000);

        finish();
    }


}
