package com.gaozhd.studydemo.androidbase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.viewpage.PageFragment3;
import com.gaozhd.studydemo.androidbase.viewpage.PageFragment4;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: FragmentActivity
 * @Description: ${todo}
 * @Date: 2016/11/27 12:00
 */
public class FragmentActivity extends android.support.v4.app.FragmentActivity {


    @BindView(R.id.btn_1)
    Button btn;
    @BindView(R.id.btn_2)
    Button btn2;

    private FragmentManager fm;

    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpage_frg);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        init();
    }

    private void init() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageFragment3 page = new PageFragment3();
                changeFragment(page, "PageFragment3");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageFragment4 page = new PageFragment4();
                hideFragment(page, "PageFragment4");
            }
        });
    }

    public void changeFragment(Fragment fragment, String tag) {
        this.fragment = fragment;

        FragmentTransaction fragmentTransaction = fm
                .beginTransaction();
        fragmentTransaction.replace(R.id.ln_frag, fragment, tag);
        try {
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fm
                .beginTransaction();
        if (fm.findFragmentByTag(tag) != null) {
            Fragment temp = fm.findFragmentByTag(tag);
            fragmentTransaction.show(temp);
            if (this.fragment != null)
                fragmentTransaction.hide(this.fragment);
            this.fragment = temp;
        } else {
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(R.id.ln_frag, fragment, tag);
            if (this.fragment != null)
                fragmentTransaction.hide(this.fragment);
            this.fragment = fragment;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
