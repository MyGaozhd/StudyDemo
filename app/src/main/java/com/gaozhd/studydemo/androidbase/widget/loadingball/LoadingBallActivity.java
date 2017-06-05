package com.gaozhd.studydemo.androidbase.widget.loadingball;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LoadingBall
 * @Description: ${todo}
 * @Date: 2017/6/1 0001 14:09
 */
public class LoadingBallActivity extends BaseActivity {

    LoadingBall loadingBall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weigt_lodingball);
        loadingBall = (LoadingBall) findViewById(R.id.loading_ball);
        loadingBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBall.startTotalAnimator();
            }
        });
    }
}
