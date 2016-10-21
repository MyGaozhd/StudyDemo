package com.gaozhd.studydemo.designpattern.proxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.gaozhd.studydemo.GlobalInfoApplication;
import com.gaozhd.studydemo.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class RealShowImage implements ShowImage {

    private ImageView iv;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public RealShowImage(ImageView iv) {
        this.iv = iv;
    }

    @Override
    public void show() {
        //压缩图片
//        iv.setImageResource(R.mipmap.datu1);

//        Bitmap bitmap = BitmapFactory.decodeResource(GlobalInfoApplication.getInstance().getResources(), R.mipmap.datu1);
//        iv.setImageBitmap(compressImage(bitmap));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iv.setImageResource(R.mipmap.common_back_2);
            }
        }, 3000);
    }

    private Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {    //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }
}
