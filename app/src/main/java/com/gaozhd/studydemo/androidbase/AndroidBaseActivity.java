package com.gaozhd.studydemo.androidbase;

import android.content.Intent;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.androidbase.mvvm.MvvmActivity;
import com.gaozhd.studydemo.androidbase.recyclerview.RecyclerViewActivity0;
import com.gaozhd.studydemo.androidbase.retrofit.RetrofitActivity;
import com.gaozhd.studydemo.androidbase.rxjava.RxJavaActivity;
import com.gaozhd.studydemo.androidbase.widget.WidgetActivity;

public class AndroidBaseActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allAndroidBase;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(AndroidBaseActivity.this, RecyclerViewActivity0.class);
                break;
            case 1:
                intent.setClass(AndroidBaseActivity.this, MvvmActivity.class);
                break;
            case 3:
                intent.setClass(AndroidBaseActivity.this, RxJavaActivity.class);
                break;
            case 4:
                intent.setClass(AndroidBaseActivity.this, WidgetActivity.class);
                break;
            case 5:
                intent.setClass(AndroidBaseActivity.this, RetrofitActivity.class);
                break;
            default:
                break;
        }
    }
}
