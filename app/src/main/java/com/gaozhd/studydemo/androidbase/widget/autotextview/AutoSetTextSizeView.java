package com.gaozhd.studydemo.androidbase.widget.autotextview;

import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.gaozhd.studydemo.utils.SharedPreferencesUtils;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: AutoTextSize
 * @Description: ${todo}
 * @Date: 2017/5/18 0018 10:13
 */
public class AutoSetTextSizeView extends TextView {

    public static final String ACTION = "com.gaozhd.studydemo.androidbase.widget.autotextview.AutoTextView";

    private AutoSetTextSizeBroadcast autoBroadcast = null;
    private float textSize = 0;

    public AutoSetTextSizeView(Context context) {
        super(context);
        sizeInit();
    }

    public AutoSetTextSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sizeInit();
    }

    public AutoSetTextSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        sizeInit();
    }

    private void sizeInit() {
        textSize = (float) SharedPreferencesUtils.getParam(getContext(), "textsize", getTextSize());
        if (autoBroadcast == null) {
            autoBroadcast = new AutoSetTextSizeBroadcast(new AutoSetTextSizeBroadcast.AutoReceiver() {
                @Override
                public void onReceive() {
                    setTextSize(TypedValue.COMPLEX_UNIT_DIP, (float) SharedPreferencesUtils.getParam(getContext(), "textsize", getTextSize()));
                    invalidate();
                }
            });
            IntentFilter filter = new IntentFilter();
            filter.addAction(ACTION);
            filter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(autoBroadcast, filter);
        }
        setTextSize(textSize);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (autoBroadcast!=null){
            getContext().unregisterReceiver(autoBroadcast);
        }
    }
}
