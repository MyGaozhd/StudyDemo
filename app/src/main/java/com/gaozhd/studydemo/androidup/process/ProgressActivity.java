package com.gaozhd.studydemo.androidup.process;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ProgressActivity
 * @Description: ${todo}
 * @Date: 2016/12/26 0026 20:27
 */
public class ProgressActivity extends BaseActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progress);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        Intent intent = new Intent(ProgressActivity.this, PersnalProgress.class);
        startService(intent);
    }
}
