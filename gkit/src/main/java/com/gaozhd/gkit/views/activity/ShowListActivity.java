package com.gaozhd.gkit.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gaozhd.gkit.R;

public abstract class ShowListActivity extends BaseActivity {

    private ListView lvMain;
    private String[] allActivity;
    private ArrayAdapter<String> adapter;
    private int ResID =-1;

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
                if (intent.getComponent() != null)
                    startActivity(intent);
            }
        });
    }

    public abstract void itemClick(Intent intent, View view, int position);

}
