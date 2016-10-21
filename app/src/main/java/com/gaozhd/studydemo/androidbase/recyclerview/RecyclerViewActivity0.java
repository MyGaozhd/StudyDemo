package com.gaozhd.studydemo.androidbase.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @Description: ${todo}
 * @date 2016/10/6 22:04
 */
public class RecyclerViewActivity0 extends BaseActivity {

    private RecyclerView recyclerView = null;
    private String[] allActivity;
    private RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_androidbase_0);
        allActivity = getResources().getStringArray(R.array.allActivity);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new RVAdapter();
        recyclerView.setAdapter(rvAdapter);
    }

    class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyHolder myHolder = new MyHolder(LayoutInflater.from(RecyclerViewActivity0.this).inflate(R.layout.layout_androidbase_0_item1, null));
            return myHolder;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText("" + allActivity[position]);
        }

        @Override
        public int getItemCount() {
            return allActivity.length;
        }

        class MyHolder extends RecyclerView.ViewHolder {

            public TextView tv;

            public MyHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }
}
