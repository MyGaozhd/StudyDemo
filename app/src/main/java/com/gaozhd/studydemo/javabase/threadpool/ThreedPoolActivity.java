package com.gaozhd.studydemo.javabase.threadpool;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class ThreedPoolActivity extends BaseActivity {

    private ThreadPoolExecutor poolExecutor = null;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threespool);

        poolExecutor = new ThreadPoolExecutor(10, 15, 200, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(5));

        init();
    }

    private void init() {
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        btn = (Button) findViewById(R.id.btn_1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    poolExecutor.execute(new MyRunnable(i));
                }
            }
        });
    }

    class MyRunnable implements Runnable {
        private int a = -1;

        public MyRunnable(int k) {
            this.a = k;
        }

        public void run() {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("gaozhd", "这是第" + a + "个任务！");

            Log.d("gaozhd", "线程池中线程数目：" + poolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    poolExecutor.getQueue().size() + "，已执行玩别的任务数目：" + poolExecutor.getCompletedTaskCount());
        }
    }
}
