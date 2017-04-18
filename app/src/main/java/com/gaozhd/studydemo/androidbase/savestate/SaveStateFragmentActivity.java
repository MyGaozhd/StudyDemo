package com.gaozhd.studydemo.androidbase.savestate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.viewpage.PageFragment3;

import butterknife.ButterKnife;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: SaveStateFragmentActivity
 * @Description: ${todo}
 * @Date: 2017/4/5 0005 19:31
 */
public class SaveStateFragmentActivity extends android.support.v4.app.FragmentActivity {

    private FragmentManager fm;

    private Fragment fragment;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setContentView(R.layout.layout_viewpage_frg);
        ButterKnife.bind(this);

        fm = getSupportFragmentManager();

        SaveStateFragment page = new SaveStateFragment();
        changeFragment(page, "SaveStateFragment");
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
}
