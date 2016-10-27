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
import com.gaozhd.studydemo.androidbase.mvvm.MvvmActivity;
import com.gaozhd.studydemo.androidbase.recyclerview.RecyclerViewActivity0;
import com.gaozhd.studydemo.androidbase.rxjava.RxJavaActivity;
import com.gaozhd.studydemo.androidbase.widget.testview.TestViewActivity;

public class WidgetActivity extends BaseActivity {

    private ListView lvMain;
    private String[] allActivity;
    private ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setlvMainListener();

    }

    private void init() {
        lvMain = (ListView) findViewById(R.id.lvMain);
        allActivity = getResources().getStringArray(R.array.allwidget);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allActivity);

        lvMain.setAdapter(adapter);
    }

    private void setlvMainListener() {
        lvMain.setOnItemClickListener(new OnItemClickListener() {

            Intent intent = new Intent();

            public void onItemClick(AdapterView<?> arg0, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        intent.setClass(WidgetActivity.this, TestViewActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
