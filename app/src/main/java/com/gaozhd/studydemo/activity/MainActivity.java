package com.gaozhd.studydemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.AndroidBaseActivity;
import com.gaozhd.studydemo.designpattern.DesignPatternActivity;
import com.gaozhd.studydemo.javabase.JavaBaseActivity;

public class MainActivity extends BaseActivity {

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
        allActivity = getResources().getStringArray(R.array.allActivity);
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
                        intent.setClass(MainActivity.this, Activity0.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, Activity1.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, Activity2.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this, Activity3.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this, Activity4.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this, Activity5.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(MainActivity.this, DesignPatternActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.setClass(MainActivity.this, JavaBaseActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.setClass(MainActivity.this, AndroidBaseActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
