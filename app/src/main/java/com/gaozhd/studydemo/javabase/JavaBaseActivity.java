package com.gaozhd.studydemo.javabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.designpattern.observer.ObserverActivity;
import com.gaozhd.studydemo.javabase.reference.TestReference;
import com.gaozhd.studydemo.javabase.t.user.Test;
import com.gaozhd.studydemo.javabase.threadpool.ThreedPoolActivity;
import com.gaozhd.studydemo.javabase.trycatch.ExceptionA;
import com.gaozhd.studydemo.javabase.trycatch.ExceptionActivity;

public class JavaBaseActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allJavaBase;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(JavaBaseActivity.this, ThreedPoolActivity.class);
            case 1:
                intent.setClass(JavaBaseActivity.this, ExceptionActivity.class);
                break;
            case 2:
                new TestReference();
                break;
            default:
                break;
        }
    }

}
