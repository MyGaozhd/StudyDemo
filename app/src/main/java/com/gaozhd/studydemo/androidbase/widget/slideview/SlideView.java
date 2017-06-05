package com.gaozhd.studydemo.androidbase.widget.slideview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.gaozhd.studydemo.R;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: SlideView
 * @Description: ${todo}
 * @Date: 2017/6/4 0004 14:46
 */
public class SlideView extends View {
    private String[] mLetters;
    private Paint mPaint;
    private int mChoose;
    private float mDensity;
    private RectF mIsDawnRect = new RectF();
    private boolean mIsBeingDragger, mStartEndAnim;
    private int mTouchSlop;

    private float mHalfWidth, mHalfHeight;
    private float mLetterHeight;
    private float mAnimStep;

    private float mY;
    private float mInitDownY;

    public SlideView(Context context) {
        this(context, null);
    }

    public SlideView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mLetters = context.getResources().getStringArray(R.array.slidearray);

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        mDensity = getContext().getResources().getDisplayMetrics().density;
        setPadding(0, dp2Px(20), 0, dp2Px(20));
    }

    private int dp2Px(int dip) {
        return (int) (dip * mDensity + 0.5f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHalfHeight = h - getPaddingTop() - getPaddingBottom();
        mHalfWidth = w - dp2Px(16);
        mLetterHeight = mHalfHeight / mLetters.length;
        int textSize = (int) (mLetterHeight * 0.7);
        mPaint.setTextSize(textSize);
        mIsDawnRect.set(w - dp2Px(32), 0, w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mLetters.length; i++) {
            float letterPosY = mLetterHeight * (1 + i) + getPaddingTop();
            float diff;
            float diffY;
            float diffX;

            //当前字母被选中
            if (mChoose == i && i != 0 && i != mLetters.length - 1) {
                diff = 2.2f;
                diffX = 0;
                diffY = 0f;
            } else {
                float maxPox = Math.abs(mY - letterPosY) / mHalfHeight * 7;
                diff = (float) Math.max(1f, 2.2 - maxPox);

                if (mStartEndAnim && diff != 1f) {
                    //在点击的范围内
                    diff -= mAnimStep;
                    if (diff < 1) {
                        diff = 1f;
                    } else {

                    }
                } else if (!mIsBeingDragger) {
                    //正常的显示
                    diff = 1f;
                }
                diffY = maxPox * 50f * (letterPosY > mY ? -1 : 1);
                diffX = maxPox * 100;
            }

            canvas.save();
            //写字母
            canvas.scale(diff, diff, mHalfWidth * 1.20f + diffX, letterPosY + diffY);
            if (diff == 1f) {
                mPaint.setAlpha(255);
                mPaint.setTypeface(Typeface.DEFAULT);
            } else {
                int alpha = (int) (255 * (1 - Math.min(0.9, diff - 1)));
                if (mChoose == i) {
                    alpha = 255;
                }
                mPaint.setAlpha(alpha);
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
            canvas.drawText(mLetters[i], mHalfWidth, letterPosY, mPaint);
            canvas.restore();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mIsBeingDragger = false;
                float downY = event.getY();
                if (!mIsDawnRect.contains(event.getX(), event.getY())) {
                    return false;
                }
                mInitDownY = downY;
                break;
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                float diff = Math.abs(y - mInitDownY);
                if (diff > mTouchSlop && !mIsBeingDragger) {
                    mIsBeingDragger = true;
                }
                if (mIsBeingDragger) {
                    mY = y;
                    float moveY = y - getPaddingTop();
                    int character = (int) (moveY / mHalfHeight * mLetters.length);

                    if (mChoose != character) {
                        if (character >= 0 && character < mLetters.length) {
                            mChoose = character;
                        }
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mStartEndAnim = false;
                mIsBeingDragger = false;
                mChoose = -1;
                mAnimStep = 0f;
                invalidate();
                return false;
        }
        return true;
    }
}
