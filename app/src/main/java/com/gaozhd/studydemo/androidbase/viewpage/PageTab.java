package com.gaozhd.studydemo.androidbase.viewpage;

import com.gaozhd.studydemo.R;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PageTab
 * @Description: ${todo}
 * @Date: 2016/11/27 9:41
 */
public enum PageTab {

    FRAG1(0, PageFragment1.class, 0, R.layout.layout_viewpage_frg_1),
    FRAG2(1, PageFragment2.class, 0, R.layout.layout_viewpage_frg_2);

    public final int tabIndex;
    public final Class<? extends BaseFragment> clazz;

    public final int resId;

    public final int fragmentId;

    public final int layoutId;

    PageTab(int index, Class<? extends BaseFragment> clazz, int resId, int layoutId) {
        this.tabIndex = index;
        this.clazz = clazz;
        this.resId = resId;
        this.fragmentId = index;
        this.layoutId = layoutId;
    }
}
