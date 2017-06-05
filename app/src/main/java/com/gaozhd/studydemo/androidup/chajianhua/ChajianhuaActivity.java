package com.gaozhd.studydemo.androidup.chajianhua;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.FileUtil;
import com.gaozhd.studydemo.utils.file.AttachmentStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dalvik.system.DexClassLoader;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: ChajianhuaActivity
 * @Description: ${todo}
 * @Date: 2017/6/4 0004 7:56
 */
public class ChajianhuaActivity extends BaseActivity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chajianhua);
        ButterKnife.bind(this);
        initFile();
    }

    String resourceName = "datu1";
    String fileName = "chajian";
    String packageName = "com.example.administrator.chajiandemo";

    private void initFile() {

        File file = getApkFile();
        AssetManager assetManager = PluginResources.getAssetManager(file, getResources());
        Resources resources = PluginResources.getPluginResources(getResources(), assetManager);
        DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(), this.getDir(fileName + ".apk", Context.MODE_PRIVATE).getAbsolutePath(), null, this.getClassLoader());
        try {
            Class<?> loadClass = classLoader.loadClass(packageName + ".R$mipmap");
            Field[] fields = loadClass.getFields();
            for (Field field : fields) {
                if (field.getName().equals(resourceName)) {
                    int resourseId = field.getInt(loadClass.getClass());
                    Drawable d = resources.getDrawable(resourseId);
                    iv.setBackgroundDrawable(d);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private File getApkFile() {
        String filePath = this.getCacheDir() + File.separator + fileName + ".apk";
        File file = new File(filePath);
        if (file.exists()) {
            return file;
        } else {
            try {
                InputStream is = this.getAssets().open(fileName + ".apk");
                FileOutputStream os = new FileOutputStream(file);
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                }
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @OnClick(R.id.iv)
    public void onClick() {
    }
}
