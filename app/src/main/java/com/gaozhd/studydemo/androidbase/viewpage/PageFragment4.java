package com.gaozhd.studydemo.androidbase.viewpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaozhd.studydemo.R;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PageFragment1
 * @Description: ${todo}
 * @Date: 2016/11/27 9:45
 */
public class PageFragment4 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int size = getActivity().getSupportFragmentManager().getFragments().size();
        Log.e("gaozhd", "onCreateView Size:" + size + "");

        return view = inflater.inflate(R.layout.layout_viewpage_frg_4, null);
    }

    @Override
    public void onResume() {
        super.onResume();
        int size = getActivity().getSupportFragmentManager().getFragments().size();
        Log.e("gaozhd", "onResume Size:" + size + "");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        int size = getActivity().getSupportFragmentManager().getFragments().size();
        Log.e("gaozhd", "onHiddenChanged Size:" + size + " \n Hidden:" + hidden);
    }
}
