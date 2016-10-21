package com.gaozhd.studydemo.designpattern.proxy;

import android.os.Bundle;
import android.widget.ImageView;

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
public class ProxyActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        ShowImage showImage = new ProxyShowImage((ImageView) findViewById(R.id.iv));
        showImage.show();
    }
}
