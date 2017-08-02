package com.gaozhd.studydemo.androidbase;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.Activity0;
import com.gaozhd.studydemo.activity.Activity1;
import com.gaozhd.studydemo.activity.Activity2;
import com.gaozhd.studydemo.activity.Activity3;
import com.gaozhd.studydemo.activity.Activity4;
import com.gaozhd.studydemo.activity.Activity5;
import com.gaozhd.studydemo.activity.MainActivity;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.androidbase.animation.AnimationActivity;
import com.gaozhd.studydemo.androidbase.fragment.FragmentActivity;
import com.gaozhd.studydemo.androidbase.greendao.GreendaoActivity;
import com.gaozhd.studydemo.androidbase.layout.LayoutActivity;
import com.gaozhd.studydemo.androidbase.lifecycle.activity.LifeCycleActivity1;
import com.gaozhd.studydemo.androidbase.mvvm.MvvmActivity;
import com.gaozhd.studydemo.androidbase.oom.OOMActivity;
import com.gaozhd.studydemo.androidbase.recyclerview.RecyclerViewActivity0;
import com.gaozhd.studydemo.androidbase.retrofit.RetrofitActivity;
import com.gaozhd.studydemo.androidbase.rxjava.RxJavaActivity;
import com.gaozhd.studydemo.androidbase.savestate.SaveStateActivity;
import com.gaozhd.studydemo.androidbase.touch.TouchActivity;
import com.gaozhd.studydemo.androidbase.viewpage.ViewPageActivity;
import com.gaozhd.studydemo.androidbase.webview.WebviewLocalFirstActivity;
import com.gaozhd.studydemo.androidbase.webview.WebviewWithCookieActivity;
import com.gaozhd.studydemo.androidbase.widget.WidgetActivity;
import com.gaozhd.studydemo.androidbase.xmlparser.XmlParserActivity;

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
            case 12:
                intent.setClass(AndroidBaseActivity.this, TouchActivity.class);
                break;
            case 13:
                intent.setClass(AndroidBaseActivity.this, WebviewWithCookieActivity.class);
                break;
            case 14:
                intent.setClass(AndroidBaseActivity.this, SaveStateActivity.class);
                intent.putExtra("key1", "ss");
                intent.putExtra("key2", 11);
                break;
            case 15:
                intent.setClass(AndroidBaseActivity.this, WebviewLocalFirstActivity.class);
                break;
            case 16:
                intent.setClass(AndroidBaseActivity.this, XmlParserActivity.class);
                break;
            case 17:
                intent.setClass(AndroidBaseActivity.this, LayoutActivity.class);
                break;
            case 18:
                intent.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("https://www.baidu.com/"));
                break;
            case 19:
                intent.setClass(AndroidBaseActivity.this, Activity0.class);
                break;
            case 20:
                intent.setClass(AndroidBaseActivity.this, Activity1.class);
                break;
            case 21:
                intent.setClass(AndroidBaseActivity.this, Activity2.class);
                break;
            case 22:
                intent.setClass(AndroidBaseActivity.this, Activity3.class);
                break;
            case 23:
                intent.setClass(AndroidBaseActivity.this, Activity4.class);
                break;
            case 24:
                intent.setClass(AndroidBaseActivity.this, Activity5.class);
                break;
            default:
                break;
        }
    }
}
