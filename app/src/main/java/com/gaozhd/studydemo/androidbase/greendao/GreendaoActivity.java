package com.gaozhd.studydemo.androidbase.greendao;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.androidbase.greendao.biz.DBUserBiz;
import com.gaozhd.studydemo.androidbase.greendao.entry.DBUser;
import com.gaozhd.studydemo.utils.LogUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: GreendaoActivity
 * @Description: ${todo}
 * @Date: 2016/11/20 10:30
 */
public class GreendaoActivity extends BaseActivity {

    DBUserBiz userBiz;
    @BindView(R.id.tv)
    TextView tv;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_greendao);
        ButterKnife.bind(this);
        userBiz = new DBUserBiz();
    }

    private void add() {
        count++;
        List<DBUser> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
//            DBUser u = new DBUser(i + "", "number:" + i, "name:" + i, "sex:" + i, "classID:" + i);
            DBUser u = new DBUser(null, "number:" + i, "name:" + i, "sex:" + i, "classID:" + count);
//            userBiz.insertOrReplace(u);
            list.add(u);
        }
        userBiz.insertList(list);
        select();
    }

    public static final int ONCESIZE = 200;

    private void delete() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i + "");
        }

        if (list.size() > ONCESIZE) {
            int size = list.size();
            while (size > ONCESIZE) {
                List<String> temp = list.subList(size - ONCESIZE, size);
                LogUtil.log(new Gson().toJson(temp));
                LogUtil.log(temp.size() + "");
                size -= ONCESIZE;
            }
            List<String> temp = list.subList(size - ONCESIZE, size);
            LogUtil.log(new Gson().toJson(temp));
            LogUtil.log(temp.size() + "");
        }

    }

    private void update() {
    }

    private void select() {
        List<DBUser> dbUsers = userBiz.loadAll();
        StringBuilder b = new StringBuilder();
        for (DBUser d : dbUsers) {
            b.append("ID:" + d.getId() + "number:" + d.getNumber() + " Name:" + d.getName() + " classID:" + d.getClassID() + "\n");
        }
        tv.setText(b.toString());
    }

    @OnClick({R.id.add, R.id.delete, R.id.update, R.id.select})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.update:
                update();
                break;
            case R.id.select:
                select();
                break;
        }
    }
}
