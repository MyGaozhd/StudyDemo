package com.gaozhd.studydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.androidbase.AndroidBaseActivity;
import com.gaozhd.studydemo.androidup.AndroidUpActivity;
import com.gaozhd.studydemo.designpattern.DesignPatternActivity;
import com.gaozhd.studydemo.javabase.JavaBaseActivity;
import com.gaozhd.studydemo.utils.LogUtil;
import com.gaozhd.studydemo.utils.storage.StorageType;
import com.gaozhd.studydemo.utils.storage.StorageUtil;
import com.media.mediaplayer.activities.VideoActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestActivity extends ShowListActivity {

    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InputStream is = getResources().openRawResource(com.media.mediaplayer.R.raw.vd);
        path = "" + StorageUtil.getDirectoryByDirType(StorageType.TYPE_TIANTAN) + File.separator + "vd.mp4";
        save(is, path);
    }

    /**
     * @param is
     * @param filePath
     * @return 保存失败，返回-1
     */
    public static long save(InputStream is, String filePath) {
        File f = new File(filePath);
        if (!f.getParentFile().exists()) {// 如果不存在上级文件夹
            f.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        try {
            f.createNewFile();
            fos = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[8091];
            while ((read = is.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            return f.length();
        } catch (IOException e) {
            if (f != null && f.exists()) {
                f.delete();
            }
            return -1;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getResID() {
        return R.array.testActivity;
    }

    @Override
    public void itemClick(Intent intent, View view, int position) {
        switch (position) {
            case 0:
                intent.setClass(TestActivity.this, VideoActivity.class);
                intent.putExtra("videoPath", path);
                intent.putExtra("videoTitle", "vd");
                break;
            default:
                break;
        }
    }
}
