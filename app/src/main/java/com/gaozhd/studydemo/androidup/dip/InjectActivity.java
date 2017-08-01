package com.gaozhd.studydemo.androidup.dip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.LogUtil;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: InjectActivity
 * @Description: ${todo}
 * @Date: 2017/6/22 0022 16:31
 */
@ContentView(R.layout.layout_inject)
public class InjectActivity extends BaseActivity {

    @ViewInject(R.id.btn1)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.inJect(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.log(button.getText().toString());
    }
}
