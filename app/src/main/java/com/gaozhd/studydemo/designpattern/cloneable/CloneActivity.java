package com.gaozhd.studydemo.designpattern.cloneable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: CloneActivity
 * @Description: ${todo}
 * @Date: 2016/11/10 19:47
 */
public class CloneActivity extends BaseActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.tv)
    TextView tv;
    Money money = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_clone1);
        ButterKnife.bind(this);

        money = new Money();
        money.setCount(100);
        money.setUserName("servi");
    }


    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Money moneyClone = money.clone();
                tv.setText("moneyClone:" + moneyClone.getCount() + "\n" + "money:" + money.getCount() + "\n");
                break;
            case R.id.btn2:
                break;
        }
    }
}
