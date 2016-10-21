package com.gaozhd.studydemo.androidbase.mvp;

import android.os.Bundle;
import android.telecom.DisconnectCause;
import android.widget.EditText;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LoginActivity
 * @Description: ${todo}
 * @date 2016/10/12 19:22
 */
public class LoginActivity extends BaseActivity implements Ilogin {

    private EditText et_un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mvp1);
    }

    @Override
    public String getUn() {
        return et_un.getText().toString();
    }

    @Override
    public String getUp() {
        return et_un.getText().toString();
    }

    @Override
    public void updateUI() {

    }
}
