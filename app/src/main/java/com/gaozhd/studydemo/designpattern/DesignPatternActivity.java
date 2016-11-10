package com.gaozhd.studydemo.designpattern;

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
import com.gaozhd.studydemo.designpattern.cloneable.CloneActivity;
import com.gaozhd.studydemo.designpattern.decorator.DecoratorActivity;
import com.gaozhd.studydemo.designpattern.observer.ObserverActivity;
import com.gaozhd.studydemo.designpattern.proxy.ProxyActivity;

public class DesignPatternActivity extends ShowListActivity {
    @Override
    public int getResID() {
        return R.array.allDesign;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(DesignPatternActivity.this, ObserverActivity.class);
                break;
            case 1:
                intent.setClass(DesignPatternActivity.this, ProxyActivity.class);
                break;
            case 2:
                intent.setClass(DesignPatternActivity.this, DecoratorActivity.class);
                break;
            case 3:
                intent.setClass(DesignPatternActivity.this, CloneActivity.class);
                break;
            default:
                break;
        }
    }
}

