package com.gaozhd.studydemo.androidbase.widget.testview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.utils.LogUtil;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: TestView
 * @Description: ${todo}
 * @date 2016/10/27 13:47
 */
public class TestView extends View {

    //文字内容
    private String textContent = "";
    //文字大小
    private int textSize = 15;
    //文字颜色
    private int textColor = Color.parseColor("#000000");
    //背景颜色
    private int backColor = Color.parseColor("#ffffff");
    //画笔
    private Paint mPaint;

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        //初始化自定义属性
        initAttribute(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        //初始化自定义属性
        initAttribute(context, attrs);
    }

    private void initAttribute(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TestView);
        textContent = a.getString(R.styleable.TestView_textContent);
        textSize = (int) a.getDimension(R.styleable.TestView_textSize, 15);
        textColor = a.getColor(R.styleable.TestView_textColor, textColor);
        backColor = a.getColor(R.styleable.TestView_backColor, backColor);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        LogUtil.log("widthMeasureSpec:" + widthMeasureSpec);
        LogUtil.log("heightMeasureSpec:" + heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        LogUtil.log("widthMode;" + widthMode);
        LogUtil.log("heightMode:" + heightMode);
        LogUtil.log("widthSize:" + widthSize);
        LogUtil.log("heightSize:" + heightSize);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        LogUtil.log("changed:" + changed);
        LogUtil.log("left:" + left);
        LogUtil.log("top:" + top);
        LogUtil.log("right:" + right);
        LogUtil.log("bottom:" + bottom);
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mPaint == null)
            mPaint = new Paint();

        int width = getWidth();
        int height = getHeight();

        /**
         * 背景
         */
        canvas.drawColor(backColor);

        /**
         *文字
         */
        mPaint.setStrokeWidth(0);
        mPaint.setColor(textColor);//文字颜色
        mPaint.setTextSize(textSize);//文字大小
        mPaint.setTypeface(Typeface.DEFAULT); //设置字体

        //设置字体居中的方法
        Rect rect = new Rect();
        getDrawingRect(rect);
        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        int basaline = (rect.bottom + rect.top - fontMetricsInt.bottom - fontMetricsInt.top) / 2;
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(textContent, rect.centerX(), basaline, mPaint);

        /**
         * 线
         */
        canvas.drawLine(rect.left, rect.centerY(), rect.right, rect.centerY(), mPaint);

        /**
         * 矩形
         */
        Rect textRect = new Rect();
        mPaint.getTextBounds(textContent, 0, textContent.length(), textRect);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect((width / 2 - textRect.width() / 2), (height / 2 - textRect.height() / 2), (width / 2 + textRect.width() / 2), (height / 2 + textRect.height() / 2), mPaint);
    }
}
