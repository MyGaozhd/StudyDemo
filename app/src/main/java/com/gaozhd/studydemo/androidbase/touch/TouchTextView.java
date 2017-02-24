package com.gaozhd.studydemo.androidbase.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.gaozhd.studydemo.utils.LogUtil;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TouchTextView
 * @Description: ${todo}
 * @Date: 2017/2/14 0014 19:43
 */
public class TouchTextView extends TextView {
    public TouchTextView(Context context) {
        super(context);
    }

    public TouchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtil.log(" TouchTextView : dispatchTouchEvent----->" + getText());
        return super.dispatchTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        LogUtil.log(" TouchTextView : onTouchEvent----->" + getText());
        return super.onTouchEvent(event);
    }
}
