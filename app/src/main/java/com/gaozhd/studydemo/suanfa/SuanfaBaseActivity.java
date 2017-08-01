package com.gaozhd.studydemo.suanfa;

import android.content.Intent;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.javabase.reference.TestReference;
import com.gaozhd.studydemo.javabase.threadpool.ThreedPoolActivity;
import com.gaozhd.studydemo.javabase.trycatch.ExceptionActivity;
import com.gaozhd.studydemo.suanfa.sort.Sort;
import com.gaozhd.studydemo.utils.LogUtil;

public class SuanfaBaseActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allSuanfa;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                Sort sort = new Sort();
//                sort.mapPao();
                LogUtil.log("-------------------------------------------------------------");
                sort.kuaisu(sort.data, 0, sort.data.length - 1);
                break;
            default:
                break;
        }
    }

}
