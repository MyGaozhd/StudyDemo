package com.gaozhd.studydemo.androidbase.viewpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class PageFragment2 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.layout_viewpage_frg_2, null);
    }
}
