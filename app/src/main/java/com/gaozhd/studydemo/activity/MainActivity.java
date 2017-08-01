package com.gaozhd.studydemo.activity;

import android.view.View;
import android.content.Intent;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.AndroidBaseActivity;
import com.gaozhd.studydemo.androidup.AndroidUpActivity;
import com.gaozhd.studydemo.designpattern.DesignPatternActivity;
import com.gaozhd.studydemo.javabase.JavaBaseActivity;
import com.gaozhd.studydemo.suanfa.SuanfaBaseActivity;

public class MainActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allActivity;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(MainActivity.this, Activity0.class);
                break;
            case 1:
                intent.setClass(MainActivity.this, Activity1.class);
                break;
            case 2:
                intent.setClass(MainActivity.this, Activity2.class);
                break;
            case 3:
                intent.setClass(MainActivity.this, Activity3.class);
                break;
            case 4:
                intent.setClass(MainActivity.this, Activity4.class);
                break;
            case 5:
                intent.setClass(MainActivity.this, Activity5.class);
                break;
            case 6:
                intent.setClass(MainActivity.this, DesignPatternActivity.class);
                break;
            case 7:
                intent.setClass(MainActivity.this, JavaBaseActivity.class);
                break;
            case 8:
                intent.setClass(MainActivity.this, AndroidBaseActivity.class);
                break;
            case 9:
                String s = null;
                if (s.equals("aaa"))
                    return;
                break;
            case 10:
                intent.setClass(MainActivity.this, AndroidUpActivity.class);
                break;
            case 11:
                intent.setClass(MainActivity.this, SuanfaBaseActivity.class);
                break;
            default:
                break;
        }
    }
}
