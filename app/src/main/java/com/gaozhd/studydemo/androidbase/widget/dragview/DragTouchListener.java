package com.gaozhd.studydemo.androidbase.widget.dragview;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: DragTouchListener
 * @Description: ${todo}
 * @Date: 2017/6/5 0005 19:43
 */
public class DragTouchListener implements View.OnTouchListener {

    private View point;
    private Context context;
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    DragView dragView;

    public DragTouchListener(View point, Context context) {
        this.point = point;
        this.context = context;
        init();
    }

    private void init() {
        dragView = new DragView(context);
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            this.point.setVisibility(View.INVISIBLE);
            this.dragView.setmStatusBarHeight(getStatusBarHeight(point));
            this.dragView.initCenter(event.getRawX(),event.getRawY());

            this.dragView.setOnDisappearListener(new DragView.OnDisappearListener() {
                @Override
                public void onDisappear(PointF mDragCenter) {

                }

                @Override
                public void onReset(boolean isOutOfRange) {

                }
            });
            windowManager.addView(dragView, layoutParams);
        }
        return false;
    }

    public int getStatusBarHeight(View v) {
        if (v == null) {
            return 0;
        }
        Rect frame = new Rect();
        v.getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }
}
