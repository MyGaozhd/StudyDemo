package com.gaozhd.studydemo.androidbase.savestate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.viewpage.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PageFragment1
 * @Description: ${todo}
 * @Date: 2016/11/27 9:45
 */
public class SaveStateFragment extends BaseFragment {

    @BindView(R.id.tv)
    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = view = inflater.inflate(R.layout.layout_viewpage_frg_3, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
}
