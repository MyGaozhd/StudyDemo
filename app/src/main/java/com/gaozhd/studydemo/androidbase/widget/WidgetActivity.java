package com.gaozhd.studydemo.androidbase.widget;

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
import com.gaozhd.studydemo.androidbase.mvvm.MvvmActivity;
import com.gaozhd.studydemo.androidbase.recyclerview.RecyclerViewActivity0;
import com.gaozhd.studydemo.androidbase.rxjava.RxJavaActivity;
import com.gaozhd.studydemo.androidbase.widget.autotextview.AutoTextViewActivity;
import com.gaozhd.studydemo.androidbase.widget.dragview.DragActivity;
import com.gaozhd.studydemo.androidbase.widget.loadingball.LoadingBallActivity;
import com.gaozhd.studydemo.androidbase.widget.passwordedit.PasswordEditActivity;
import com.gaozhd.studydemo.androidbase.widget.slideview.SlideViewActivity;
import com.gaozhd.studydemo.androidbase.widget.studyview.StudyViewActivity;
import com.gaozhd.studydemo.androidbase.widget.testview.TestViewActivity;

public class WidgetActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allwidget;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(WidgetActivity.this, TestViewActivity.class);
                break;
            case 1:
                intent.setClass(WidgetActivity.this, StudyViewActivity.class);
                break;
            case 2:
                intent.setClass(WidgetActivity.this, AutoTextViewActivity.class);
                break;
            case 3:
                intent.setClass(WidgetActivity.this, LoadingBallActivity.class);
                break;
            case 4:
                intent.setClass(WidgetActivity.this, SlideViewActivity.class);
                break;
            case 5:
                intent.setClass(WidgetActivity.this, DragActivity.class);
                break;
            case 6:
                intent.setClass(WidgetActivity.this, PasswordEditActivity.class);
                break;
            default:
                break;
        }
    }
}
