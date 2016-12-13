package com.gaozhd.studydemo.androidbase.viewpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PageAdapter
 * @Description: ${todo}
 * @Date: 2016/11/27 9:24
 */
public class PageAdapter extends FragmentPagerAdapter {

    private BaseFragment[] fragments;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new BaseFragment[2];
        for (PageTab page : PageTab.values()) {
            try {
                BaseFragment fragment = null;

                List<Fragment> fs = fm.getFragments();
                if (fs != null) {
                    for (Fragment f : fs) {
                        if (f.getClass() == page.clazz) {
                            fragment = (BaseFragment) f;
                            break;
                        }
                    }
                }

                if (fragment == null) {
                    fragment = page.clazz.newInstance();
                }

                fragments[page.tabIndex] = fragment;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null && fragments.length > position) {
            return fragments[position];
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
