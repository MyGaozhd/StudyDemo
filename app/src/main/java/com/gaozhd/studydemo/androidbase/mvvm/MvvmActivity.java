package com.gaozhd.studydemo.androidbase.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.EditText;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
//import com.gaozhd.studydemo.databinding.LayoutMvvm1Binding;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: MvvmActivity
 * @Description: ${todo}
 * @date 2016/10/12 14:36
 */
public class MvvmActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LayoutMvvm1Binding layoutMvvm1Binding = DataBindingUtil.setContentView(this, R.layout.layout_mvvm1);
//        User user = new User("gaozhd", "king");
//        layoutMvvm1Binding.setUser(user);
    }
}
