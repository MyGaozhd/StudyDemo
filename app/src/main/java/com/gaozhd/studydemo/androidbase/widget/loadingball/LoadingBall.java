package com.gaozhd.studydemo.androidbase.widget.loadingball;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.DecelerateInterpolator;

import com.gaozhd.studydemo.R;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LoadingBall
 * @Description: ${todo}
 * @Date: 2017/6/1 0001 14:11
 */
public class LoadingBall extends SurfaceView implements SurfaceHolder.Callback {

    public static final int STATE_DOWN = 1;
    public static final int STATE_UP = 2;

    private Paint mPaint;
    private Path mPath;
    private int lineWidth;
    private int lineHeight;
    private int lineColor;
    private int pointColor;

    private int state;

    private float mDownDistance;
    private float mUpDistance;
    private float mFreeDistance;

    //小球是否脱离绳子
    private boolean isBounce;
    private boolean isBallFreeUp;
    private boolean isUpControlDied;
    private boolean isAnimationShowing;

    //属性动画
    private ValueAnimator downControl;
    private ValueAnimator upControl;
    private ValueAnimator freeDownControl;

    private AnimatorSet animatorSet;

    public LoadingBall(Context context) {
        this(context, null);
    }

    public LoadingBall(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(lineHeight);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();
        getHolder().addCallback(this);
        initControl();
    }

    private void initControl() {
        downControl = ValueAnimator.ofInt(0, 1);
        downControl.setDuration(500);
        downControl.setInterpolator(new DecelerateInterpolator());
        downControl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDownDistance = 50 * animation.getAnimatedFraction();
                postInvalidate();
            }
        });
        downControl.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                state = STATE_DOWN;
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        upControl = ValueAnimator.ofFloat(0, 1);
        upControl.setDuration(900);
        upControl.setInterpolator(new DecelerateInterpolator());
        upControl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mUpDistance = 50 * animation.getAnimatedFraction();

                if (mUpDistance >= 50) {
                    isBounce = true;
                    if (!freeDownControl.isRunning() && !freeDownControl.isStarted() && !isBallFreeUp) {
                        freeDownControl.start();
                    }
                }
                postInvalidate();
            }
        });
        upControl.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                state = STATE_UP;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isUpControlDied = true;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        freeDownControl = ValueAnimator.ofFloat(0, 6.8f);
        freeDownControl.setDuration(600);
        freeDownControl.setInterpolator(new DecelerateInterpolator());
        freeDownControl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float t = animation.getAnimatedFraction();
                mFreeDistance = 34 * t - 5 * t * t;
                if (isUpControlDied) {
                    postInvalidate();
                }
            }
        });
        freeDownControl.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isBallFreeUp = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimationShowing = false;
                startTotalAnimator();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet = new AnimatorSet();
        animatorSet.play(downControl).before(upControl);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void startTotalAnimator() {
        if (isAnimationShowing) {
            return;
        }
        if (animatorSet.isRunning()) {
            animatorSet.end();
            animatorSet.cancel();
        }

        isBounce = false;
        isBallFreeUp = false;
        isUpControlDied = false;
        isAnimationShowing = true;
        animatorSet.start();
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingBall);
        lineColor = typeArray.getColor(R.styleable.LoadingBall_loadingball_ling_color, Color.BLUE);
        pointColor = typeArray.getColor(R.styleable.LoadingBall_loadingball_point_color, Color.BLACK);
        lineWidth = typeArray.getDimensionPixelOffset(R.styleable.LoadingBall_loadingball_line_width, 200);
        lineHeight = typeArray.getDimensionPixelOffset(R.styleable.LoadingBall_loadingball_line_height, 3);
        typeArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
//        //画背景
//        canvas.drawColor(Color.parseColor("#00ff00"));
        mPaint.setColor(lineColor);
        mPaint.reset();
        mPath.moveTo(getWidth() / 2 - lineWidth / 2, getHeight() / 2);

        if (state == STATE_DOWN) {

            //quadTo 回执贝塞尔曲线专用api 传入控制点坐标，终点坐标
            mPath.quadTo(
                    (float) (getWidth() / 2 - lineWidth / 2 + 0.375 * lineWidth),
                    getHeight() / 2 + mDownDistance,
                    getWidth() / 2,
                    getHeight() / 2 + mDownDistance);

            //quadTo 回执贝塞尔曲线专用api 传入控制点坐标，终点坐标
            mPath.quadTo(
                    (float) (getWidth() / 2 + lineWidth / 2 - 0.375 * lineWidth),
                    getHeight() / 2 + mDownDistance,
                    getWidth() / 2 + lineWidth / 2,
                    getHeight() / 2);

            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(mPath, mPaint);

            //绘制小球
            mPaint.setColor(pointColor);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2 + mDownDistance - 10, 10, mPaint);

        } else if (state == STATE_UP) {

            //quadTo 回执贝塞尔曲线专用api 传入控制点坐标，终点坐标
            mPath.quadTo(
                    (float) (getWidth() / 2 - lineWidth / 2 + 0.375 * lineWidth),
                    getHeight() / 2 + (50 - mUpDistance),
                    getWidth() / 2,
                    getHeight() / 2 + (50 - mUpDistance));

            //quadTo 回执贝塞尔曲线专用api 传入控制点坐标，终点坐标
            mPath.quadTo(
                    (float) (getWidth() / 2 + lineWidth / 2 - 0.375 * lineWidth),
                    getHeight() / 2 + (50 - mUpDistance),
                    getWidth() / 2 + lineWidth / 2,
                    getHeight() / 2);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(mPath, mPaint);

            //绘制小球
            if (!isBounce) {
                //小球没有脱离绳子
                mPaint.setColor(pointColor);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2 + (50 - mUpDistance) - 10, 10, mPaint);
            } else {
                //小球没有脱离绳子
                mPaint.setColor(pointColor);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2 - mFreeDistance - 10, 10, mPaint);
            }
        }

        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2 - lineWidth / 2, getHeight() / 2, 10, mPaint);
        canvas.drawCircle(getWidth() / 2 + lineWidth / 2, getHeight() / 2, 10, mPaint);
    }

    public void clear(Canvas aCanvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        aCanvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        invalidate();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas c = holder.lockCanvas(null);
        draw(c);
        holder.unlockCanvasAndPost(c);

//        Canvas canvas = null;
//        try{
//            canvas = holder.lockCanvas(null);
//            canvas.drawColor(Color.WHITE);
//            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.SRC);
//        }catch(Exception e){
//        }finally{
//            if(canvas != null){
//                holder.unlockCanvasAndPost(canvas);
//            }
//        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
