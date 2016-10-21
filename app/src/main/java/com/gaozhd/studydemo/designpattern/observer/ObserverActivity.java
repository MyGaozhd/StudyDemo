package com.gaozhd.studydemo.designpattern.observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class ObserverActivity extends BaseActivity {

    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        btn = (Button) findViewById(R.id.btn);

        final KingObservable kingObservable = new KingObservable();

        kingObservable.addObserver(new SoldierObserve("tv_1", new SoldierObserve.SoldierCallBack() {
            @Override
            public void refreshTextView(String k) {
                tv_1.setText(k);
            }
        }));

        kingObservable.addObserver(new SoldierObserve("tv_2", new SoldierObserve.SoldierCallBack() {
            @Override
            public void refreshTextView(String k) {
                tv_2.setText(k);
            }
        }));
        kingObservable.addObserver(new SoldierObserve("tv_3", new SoldierObserve.SoldierCallBack() {
            @Override
            public void refreshTextView(String k) {
                tv_3.setText(k);
            }
        }));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kingObservable.setChange(String.valueOf(System.currentTimeMillis()));
            }
        });
    }


}
