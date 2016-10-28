package com.gaozhd.studydemo.androidbase.widget.studyview;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: StudyViewGroup
 * @Description: 类似LinearLayout 上下布局   width 所有子view中最大的宽度   height 所有子view的高度之和
 * @date 2016/10/31 14:28
 */
public class StudyViewGroup extends ViewGroup {

    public StudyViewGroup(Context context) {
        super(context);
    }

    public StudyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();

        if (childCount == 0) {
            setMeasuredDimension(0, 0);
        } else {

            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(getGroupMaxWidthSize(childCount), getGroupMaxHeightSize(childCount));
            } else if (widthMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(getGroupMaxWidthSize(childCount), height);
            } else if (heightMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(width, getGroupMaxHeightSize(childCount));
            }
        }
    }

    /**
     * @Title: getGroupMaxWidthSize
     * @Description: 获取group的最大宽度
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/31 14:49
     */
    private int getGroupMaxWidthSize(int childCount) {
        int returnWidth = 0;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredWidth() > returnWidth)
                returnWidth = view.getMeasuredWidth();
        }
        return returnWidth;
    }

    /**
     * @Title: getGroupMaxHeightSize
     * @Description: 获取group的所有view的高度的和
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/10/31 14:49
     */
    private int getGroupMaxHeightSize(int childCount) {
        int returnHeight = 0;
        for (int i = 0; i < childCount; i++) {
            returnHeight += getChildAt(i).getMeasuredHeight();
        }
        return returnHeight;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int childCount = getChildCount();
        int curHeight = 0;

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int height = child.getMeasuredHeight();
            int width = child.getMeasuredWidth();
            child.layout(l, curHeight, l + width, curHeight + height);
            curHeight += height;
        }
    }
}
