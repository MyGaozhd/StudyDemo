package com.gaozhd.suanfa.views.activity;

import android.content.Intent;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gaozhd.gkit.common.util.LogUtil;
import com.gaozhd.gkit.views.activity.ShowListActivity;
import com.gaozhd.suanfa.R;
import com.gaozhd.suanfa.views.sort.Sort;


/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: SuanfaListActivity
 * @Description: ${todo}
 * @Date: 2017/8/2 0002 11:27
 */
@Route(path = "/suanfa/SuanfaListActivity")
public class SuanfaListActivity extends ShowListActivity {

    @Override
    public int getResID() {
        return R.array.allSuanfaActivity;
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
            case 1:
                intent.setClass(SuanfaListActivity.this, StackListActivity.class);
                break;
            default:
                break;
        }
    }
}
