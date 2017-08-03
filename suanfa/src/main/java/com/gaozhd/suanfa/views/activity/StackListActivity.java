package com.gaozhd.suanfa.views.activity;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gaozhd.gkit.views.activity.ShowListActivity;
import com.gaozhd.suanfa.R;
import com.gaozhd.suanfa.views.stack.Stack0;
import com.gaozhd.suanfa.views.stack.Stack1;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: SuanfaListActivity
 * @Description: ${todo}
 * @Date: 2017/8/2 0002 11:27
 */
public class StackListActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allStack;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                new Stack0();
                break;
            case 1:
                new Stack1();
                break;
            default:
                break;
        }
    }
}
