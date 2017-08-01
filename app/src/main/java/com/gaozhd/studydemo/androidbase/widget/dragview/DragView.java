package com.gaozhd.studydemo.androidbase.widget.dragview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DragView
 * @Description: ${todo}
 * @Date: 2017/6/5 0005 19:37
 */
public class DragView extends View {

    private PointF mDragCenter;
    private PointF mStickCenter;
    float dragCircleRadius = 0;
    float stickCircleRadius = 0;
    float stickMinCircleRadius = 0;
    float stickTempCircleRadius = stickCircleRadius;
    float farest = 0;
    private Paint mPaintRed;
    private Paint mTextPaint;
    private ValueAnimator mAnimator;
    private boolean isOutRange = false;
    private boolean isDisappear = false;
    private Rect rect;
    private int mStatus;
    private int mStatusBarHeight;
    private int resetDistance;
    private Context context;
    private String content = "12";
    private float mDensity;

    private OnDisappearListener onDisappearListener;

    interface OnDisappearListener {
        void onDisappear(PointF mDragCenter);

        void onReset(boolean isOutOfRange);
    }

    public OnDisappearListener getOnDisappearListener() {
        return onDisappearListener;
    }

    public void setOnDisappearListener(OnDisappearListener onDisappearListener) {
        this.onDisappearListener = onDisappearListener;
    }

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public int getmStatusBarHeight() {
        return mStatusBarHeight;
    }

    public void setmStatusBarHeight(int mStatusBarHeight) {
        this.mStatusBarHeight = mStatusBarHeight;
    }

    private void init(Context context) {
        this.context = context;
        mDensity = context.getResources().getDisplayMetrics().density;

        rect = new Rect(0, 0, 50, 50);
        stickCircleRadius = dp2Px(10);
        dragCircleRadius = dp2Px(10);
        stickMinCircleRadius = dp2Px(10);
        farest = dp2Px(80);
        resetDistance = dp2Px(40);
        mPaintRed = new Paint();
        mPaintRed.setAntiAlias(true);
        mPaintRed.setColor(Color.RED);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(18);
    }

    private int dp2Px(int dip) {

        return (int) (dip * mDensity + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0, -mStatusBarHeight);
        //是否显示
        if (!isDisappear) {
            //当移动的范围在80像素以内显示，超出就取消掉
            if (!isOutRange) {
                ShapeDrawable shapeDrawable = makeShapeDrawable();
                shapeDrawable.setBounds(rect);
                shapeDrawable.draw(canvas);
                //画圆
                canvas.drawCircle(mStickCenter.x, mStickCenter.y, stickTempCircleRadius, mPaintRed);
            }
            canvas.drawCircle(mDragCenter.x, mDragCenter.y, dragCircleRadius, mPaintRed);
            canvas.drawText(content, mDragCenter.x - dragCircleRadius / 2f, mDragCenter.y + dragCircleRadius, mTextPaint);
            canvas.restore();
        }
    }

    private ShapeDrawable makeShapeDrawable() {
        Path path = new Path();
        float distance = getCircleDistance(mDragCenter, mStickCenter);
        stickTempCircleRadius = getCurrentRadius(distance);
        float xDiff = mStickCenter.x - mDragCenter.x;
        double draTan = 0;
        if (xDiff != 0) {
            draTan = (mStickCenter.y - mDragCenter.y) / xDiff;
        }
        PointF[] dragPoint = getIntersectionPoints(mDragCenter, dragCircleRadius, draTan);
        PointF[] stickPoint = getIntersectionPoints(mStickCenter, stickTempCircleRadius, draTan);
        PointF pointByCenter = getPointByCenter(mDragCenter, mStickCenter);

        path.moveTo(stickPoint[0].x, stickPoint[0].y);
        path.quadTo(pointByCenter.x, pointByCenter.y, dragPoint[0].x, dragPoint[0].y);
        path.lineTo(dragPoint[1].x, dragPoint[1].y);

        path.quadTo(pointByCenter.x, pointByCenter.y, stickPoint[1].x, stickPoint[1].y);
        path.close();

        ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, 50, 50));
        shapeDrawable.getPaint().setColor(Color.RED);
        return shapeDrawable;
    }

    private PointF getPointByCenter(PointF mDragCenter, PointF mStickCenter) {
        float percent = 0.618f;

        PointF point = new PointF(mDragCenter.x + (mStickCenter.x - mDragCenter.x) * percent,
                mDragCenter.y + (mStickCenter.y - mDragCenter.y) * percent);
        return point;
    }

    private float getCurrentRadius(float distance) {
        distance = Math.min(distance, farest);
        float fraction = 1 - 0.8f * distance / farest;
        return fraction * stickCircleRadius;
    }


    private float getCircleDistance(PointF mDragCenter, PointF mStickCenter) {
        return (float) Math.sqrt(Math.pow(mDragCenter.x - mStickCenter.x, 2) + Math.pow(mStickCenter.y - mDragCenter.y, 2));
    }

    private static PointF[] getIntersectionPoints(PointF pMiddle, float radius, Double lineK) {
        PointF[] points = new PointF[2];
        float radian, xOffset = 0, yOffset = 0;

        if (lineK != null) {
            radian = (float) Math.atan(lineK);
            xOffset = (float) (Math.sin(radian) * radius);
            yOffset = (float) (Math.cos(radian) * radius);
        } else {
            xOffset = radius;
            yOffset = 0;
        }
        points[0] = new PointF(pMiddle.x + xOffset, pMiddle.y - yOffset);
        points[1] = new PointF(pMiddle.x - xOffset, pMiddle.y + yOffset);
        return points;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                float distance = (float) Math.sqrt(Math.pow(mDragCenter.x - mStickCenter.x, 2) + Math.pow(mStickCenter.y - mDragCenter.y, 2));
                if (distance > farest) {
                    isOutRange = true;
                    updataCenter(event.getRawY(), event.getRawY());
                    return false;
                }
                updataCenter(event.getRawY(), event.getRawY());
                break;

            case MotionEvent.ACTION_DOWN:
                if (mAnimator != null && mAnimator.isRunning()) {
                    return false;
                }
                isDisappear = false;
                isOutRange = false;
                updataCenter(event.getRawY(), event.getRawY());
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                handleActionUp();
                break;
            default:
                isOutRange = false;
                break;
        }
        return true;
    }

    public void initCenter(float x, float y) {
        this.mDragCenter = new PointF(x, y);
        this.mStickCenter = new PointF(x, y);
        invalidate();
    }

    private void updataCenter(float x, float y) {
        this.mDragCenter.x = x;
        this.mDragCenter.y = y;
        invalidate();
    }


    private void handleActionUp() {
        if (isOutRange) {
            if (getCircleDistance(mDragCenter, mStickCenter) < resetDistance) {
                if (onDisappearListener != null) {
                    onDisappearListener.onReset(isOutRange);
                    return;
                }
            }
            isDisappear = true;
            invalidate();
            if (onDisappearListener != null) {
                onDisappearListener.onDisappear(mDragCenter);
            }
        } else {
            mAnimator = ValueAnimator.ofFloat(1.0f);
            mAnimator.setInterpolator(new OvershootInterpolator(4.0f));
            final PointF start = new PointF(mDragCenter.x, mDragCenter.y);
            final PointF end = new PointF(mStickCenter.x, mStickCenter.y);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float fraction = animation.getAnimatedFraction();
                    float x = start.x + (end.x - start.x) * fraction;
                    float y = start.y + (end.y - start.y) * fraction;
                    updataCenter(x, y);
                }
            });

            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    if (onDisappearListener != null) {
                        onDisappearListener.onReset(isOutRange);
                    }
                }
            });
            if (getCircleDistance(start, end) < 10) {
                mAnimator.setDuration(10);
            } else {
                mAnimator.setDuration(500);
            }
            mAnimator.start();
        }
    }
}
