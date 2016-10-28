package com.gaozhd.studydemo.androidbase.widget.studyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Size;
import android.util.AttributeSet;
import android.util.TimingLogger;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.utils.LogUtil;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: StudyView
 * @Description: ${todo}
 * @date 2016/10/31 10:35
 */
public class StudyView extends View {

    private int backColor = Color.parseColor("#00ff00");
    private Paint paint;

    public StudyView(Context context) {
        super(context);
    }

    public StudyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs);
        if (paint == null)
            paint = new Paint();
    }

    private void initData(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StudyView);
        backColor = a.getColor(R.styleable.StudyView_studyview_backColor, backColor);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getDrawSize(0, 200, widthMeasureSpec);
        int height = getDrawSize(1, 200, heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    private int getDrawSize(int type, int defaultSize, int measureSpec) {
        int measureSize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED://父容器没有对当前View有任何限制，当前View可以任意取尺寸
                measureSize = defaultSize;
                break;
            case MeasureSpec.EXACTLY://当前的尺寸就是当前View应该取的尺寸
                measureSize = size;
                break;
            case MeasureSpec.AT_MOST://当前尺寸是当前View能取的最大尺寸
                measureSize = defaultSize;
                break;
        }

        LogUtil.log("" + (type == 0 ? "width:" : "height:") + " mode:" + getMode(mode) + " size:" + size);
        return measureSize;
    }

    private String getMode(int measureSpec) {
        String modeType = "";
        int mode = MeasureSpec.getMode(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED://父容器没有对当前View有任何限制，当前View可以任意取尺寸
                modeType = "MeasureSpec.UNSPECIFIED";
                break;
            case MeasureSpec.EXACTLY://当前的尺寸就是当前View应该取的尺寸
                modeType = "MeasureSpec.EXACTLY";
                break;
            case MeasureSpec.AT_MOST://当前尺寸是当前View能取的最大尺寸
                modeType = "MeasureSpec.AT_MOST";
                break;
        }

        return modeType;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画背景
        canvas.drawColor(backColor);
    }
}
