package com.gaozhd.studydemo.androidup;

import android.content.Intent;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.MainActivity;
import com.gaozhd.studydemo.activity.ShowListActivity;
import com.gaozhd.studydemo.androidbase.AndroidBaseActivity;
import com.gaozhd.studydemo.androidup.chajianhua.ChajianhuaActivity;
import com.gaozhd.studydemo.androidup.mpandroidchart.AndroidChartActivity;
import com.gaozhd.studydemo.androidup.process.ProgressActivity;
import com.gaozhd.studydemo.androidup.weixinhongbao.WeixinHongbaoActivity;
import com.media.mediaplayer.activities.FileExplorerActivity;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: AndroidUpActivity
 * @Description: ${todo}
 * @Date: 2016/12/26 0026 20:18
 */
public class AndroidUpActivity extends ShowListActivity {
    @Override
    public int getResID() {
        return R.array.allAndroidUp;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(AndroidUpActivity.this, ProgressActivity.class);
                break;
            case 1:
                intent.setClass(AndroidUpActivity.this, FileExplorerActivity.class);
                break;
            case 2:
                intent.setClass(AndroidUpActivity.this, AndroidChartActivity.class);
                break;
            case 3:
                intent.setClass(AndroidUpActivity.this, WeixinHongbaoActivity.class);
                break;
            case 4:
                intent.setClass(AndroidUpActivity.this, ChajianhuaActivity.class);
                break;
        }
    }
}
