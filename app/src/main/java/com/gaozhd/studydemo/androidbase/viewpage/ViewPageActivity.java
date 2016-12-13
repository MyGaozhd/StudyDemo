package com.gaozhd.studydemo.androidbase.viewpage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.widget.viewpage.StudyViewPage;

import butterknife.ButterKnife;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ViewPageActivity
 * @Description: ${todo}
 * @Date: 2016/11/27 9:20
 */
public class ViewPageActivity extends FragmentActivity {

    StudyViewPage vp;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpage);
        ButterKnife.bind(this);
        vp = (StudyViewPage) findViewById(R.id.vp);
        initPage();
    }

    private void initPage() {
        adapter = new PageAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
    }

}
