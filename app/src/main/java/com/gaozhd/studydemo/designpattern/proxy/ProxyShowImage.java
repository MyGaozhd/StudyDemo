package com.gaozhd.studydemo.designpattern.proxy;

import android.widget.ImageView;

import com.gaozhd.studydemo.R;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class ProxyShowImage implements ShowImage {

    private ImageView iv;
    private RealShowImage realShowImage;

    public ProxyShowImage(ImageView iv) {
        this.iv = iv;
        realShowImage = new RealShowImage(iv);
    }

    @Override
    public void show() {
        iv.setImageResource(R.mipmap.ewm);
        realShowImage.show();
    }
}
