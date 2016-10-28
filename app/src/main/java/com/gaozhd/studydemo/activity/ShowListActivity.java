package com.gaozhd.studydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.AndroidBaseActivity;
import com.gaozhd.studydemo.designpattern.DesignPatternActivity;
import com.gaozhd.studydemo.javabase.JavaBaseActivity;

public abstract class ShowListActivity extends BaseActivity {

    private ListView lvMain;
    private String[] allActivity;
    private ArrayAdapter<String> adapter;
    private int ResID = R.array.allActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setlvMainListener();
    }

    public abstract int getResID();

    private void init() {
        lvMain = (ListView) findViewById(R.id.lvMain);
        allActivity = getResources().getStringArray(getResID());
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allActivity);

        lvMain.setAdapter(adapter);
    }

    private void setlvMainListener() {
        lvMain.setOnItemClickListener(new OnItemClickListener() {

            Intent intent = new Intent();

            public void onItemClick(AdapterView<?> arg0, View view,
                                    int position, long id) {
                itemClick(intent, view, position);
                startActivity(intent);
            }
        });
    }

    public abstract void itemClick(Intent intent, View view, int position);

}
