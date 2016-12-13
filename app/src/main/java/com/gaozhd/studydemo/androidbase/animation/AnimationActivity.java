package com.gaozhd.studydemo.androidbase.animation;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: AnimationActivity
 * @Description: ${todo}
 * @Date: 2016/11/29 17:22
 */
public class AnimationActivity extends BaseActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.iv)
    ImageView iv;

    Animation operatingAnim = null;
    private boolean start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);
        ButterKnife.bind(this);

        operatingAnim = AnimationUtils.loadAnimation(this, R.anim.tip);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);

    }

    @OnClick(R.id.btn)
    public void onClick() {
        if (!start) {
            if (operatingAnim != null) {
                iv.startAnimation(operatingAnim);
                start = true;
            }
        } else {
            iv.clearAnimation();
            start = false;
        }
    }
}
