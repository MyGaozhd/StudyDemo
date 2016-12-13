package com.gaozhd.studydemo.androidbase.widget.viewpage;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: StudyViewPage
 * @Description: ${todo}
 * @Date: 2016/11/27 19:21
 */
public class StudyViewPage extends ViewPager {

    private boolean enableScroll = true;

    public StudyViewPage(Context context) {
        super(context);
    }

    public StudyViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isEnableScroll() {
        return enableScroll;
    }

    public void setEnableScroll(boolean enableScroll) {
        this.enableScroll = enableScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        if (enableScroll)
            super.scrollTo(x, y);
    }
}
