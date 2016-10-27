package com.gaozhd.studydemo.androidbase.widget.testview;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TestViewActivity
 * @Description: ${todo}
 * @date 2016/10/27 14:45
 */
public class TestViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_widget_testview);
    }
}
