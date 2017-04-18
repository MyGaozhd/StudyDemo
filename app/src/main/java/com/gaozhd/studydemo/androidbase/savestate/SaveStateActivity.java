package com.gaozhd.studydemo.androidbase.savestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: SaveStateActivity
 * @Description: ${todo}
 * @Date: 2017/4/5 0005 9:06
 */
public class SaveStateActivity extends BaseActivity {

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            getIntent().getExtras().putAll(getIntent().getExtras());
        }
        setContentView(R.layout.layout_savestate);
        ButterKnife.bind(this);

        tv1.setText(getIntent().getStringExtra("key1"));
        tv2.setText("text2");
//        if (savedInstanceState != null && savedInstanceState.containsKey("text1")) {
//            tv1.setText(savedInstanceState.getString("text1") + "\n" + System.currentTimeMillis());
//        }
//        if (savedInstanceState != null && savedInstanceState.containsKey("text2")) {
//            tv2.setText(savedInstanceState.getString("text2") + "\n" + System.currentTimeMillis());
//        }
//        Log.e("gaozhd", "onCreate:" + "\n text1:" + tv1.getText().toString() + "\n text2:" + tv2.getText().toString());
//        if (savedInstanceState != null && savedInstanceState.containsKey("key1")) {
//            Log.e("gaozhd", "key1:" + savedInstanceState.getString("key1") + "\n" + System.currentTimeMillis());
//        }
//        if (savedInstanceState != null && savedInstanceState.containsKey("key2")) {
//            Log.e("gaozhd", "key2:" + savedInstanceState.getInt("key2") + "\n" + System.currentTimeMillis());
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putAll(getIntent().getExtras());
        outState.putString("text1", tv1.getText().toString());
        outState.putString("text2", tv2.getText().toString());
        Log.e("gaozhd", "onSaveInstanceState:" + "\n text1:" + tv1.getText().toString() + "\n text2:" + tv2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState.containsKey("text1")) {
//            tv1.setText(savedInstanceState.getString("text1") + "\n" + System.currentTimeMillis());
//        }
//        if (savedInstanceState.containsKey("text2")) {
//            tv2.setText(savedInstanceState.getString("text2") + "\n" + System.currentTimeMillis());
//        }
//
//
//        Log.e("gaozhd", "onRestoreInstanceState:" + "\n text1:" + tv1.getText().toString() + "\n text2:" + tv2.getText().toString());
//        if (savedInstanceState != null && savedInstanceState.containsKey("key1")) {
//            Log.e("gaozhd", "key1:" + savedInstanceState.getString("key1") + "\n" + System.currentTimeMillis());
//        }
//
//        if (savedInstanceState != null && savedInstanceState.containsKey("key2")) {
//            Log.e("gaozhd", "key2:" + savedInstanceState.getInt("key2") + "\n" + System.currentTimeMillis());
//        }
    }

    @OnClick(R.id.btn)
    public void onClick() {
        Intent intent = new Intent(this, SaveStateActivity.class);
        intent.putExtra("key1", "ss");
        intent.putExtra("key2", 11);
        startActivity(intent);
    }
}
