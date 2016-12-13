package com.gaozhd.studydemo.androidbase;

import android.content.Intent;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.androidbase.animation.AnimationActivity;
import com.gaozhd.studydemo.androidbase.fragment.FragmentActivity;
import com.gaozhd.studydemo.androidbase.greendao.GreendaoActivity;
import com.gaozhd.studydemo.androidbase.lifecycle.activity.LifeCycleActivity1;
import com.gaozhd.studydemo.androidbase.mvvm.MvvmActivity;
import com.gaozhd.studydemo.androidbase.oom.OOMActivity;
import com.gaozhd.studydemo.androidbase.recyclerview.RecyclerViewActivity0;
import com.gaozhd.studydemo.androidbase.retrofit.RetrofitActivity;
import com.gaozhd.studydemo.androidbase.rxjava.RxJavaActivity;
import com.gaozhd.studydemo.androidbase.viewpage.ViewPageActivity;
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
            case 6:
                intent.setClass(AndroidBaseActivity.this, OOMActivity.class);
                break;
            case 7:
                intent.setClass(AndroidBaseActivity.this, LifeCycleActivity1.class);
                break;
            case 8:
                intent.setClass(AndroidBaseActivity.this, GreendaoActivity.class);
                break;
            case 9:
                intent.setClass(AndroidBaseActivity.this, ViewPageActivity.class);
                break;
            case 10:
                intent.setClass(AndroidBaseActivity.this, FragmentActivity.class);
                break;
            case 11:
                intent.setClass(AndroidBaseActivity.this, AnimationActivity.class);
                break;
            default:
                break;
        }
    }
}
