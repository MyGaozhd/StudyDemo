package com.gaozhd.studydemo.androidbase.widget.passwordedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PasswordEditView
 * @Description: ${todo}
 * @Date: 2017/6/8 0008 19:28
 */
public class PasswordEditView extends EditText {

    private Paint mPaint;
    private Paint mPaintContent;
    private Paint mPaintArc;

    public PasswordEditView(Context context) {
        this(context, null);
    }

    public PasswordEditView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PasswordEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);

        mPaintContent = new Paint();
        mPaintContent.setAntiAlias(true);
        mPaintContent.setColor(Color.GRAY);
        mPaintContent.setStyle(Paint.Style.FILL);

        mPaintArc = new Paint();
        mPaintArc.setAntiAlias(true);
        mPaintArc.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
