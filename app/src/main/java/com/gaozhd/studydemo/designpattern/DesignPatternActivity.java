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
import com.gaozhd.studydemo.designpattern.decorator.DecoratorActivity;
import com.gaozhd.studydemo.designpattern.observer.ObserverActivity;
import com.gaozhd.studydemo.designpattern.proxy.ProxyActivity;

public class DesignPatternActivity extends BaseActivity {

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
        allActivity = getResources().getStringArray(R.array.allDesign);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allActivity);

        lvMain.setAdapter(adapter);
    }

    private void setlvMainListener() {
        // registerForContextMenu(lvMain);
        lvMain.setOnItemClickListener(new OnItemClickListener() {

            Intent intent = new Intent();

            public void onItemClick(AdapterView<?> arg0, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        intent.setClass(DesignPatternActivity.this, ObserverActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(DesignPatternActivity.this, ProxyActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(DesignPatternActivity.this, DecoratorActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
