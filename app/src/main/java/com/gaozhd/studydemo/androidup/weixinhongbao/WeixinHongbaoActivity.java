package com.gaozhd.studydemo.androidup.weixinhongbao;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: WeixinHongbaoActivity
 * @Description: ${todo}
 * @Date: 2017/5/31 0031 19:27
 */
public class WeixinHongbaoActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weixin_hongbao);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        Intent intent=new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }
}
