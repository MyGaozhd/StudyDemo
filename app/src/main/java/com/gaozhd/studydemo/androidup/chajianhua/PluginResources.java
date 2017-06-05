package com.gaozhd.studydemo.androidup.chajianhua;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: PluginResources
 * @Description: ${todo}
 * @Date: 2017/6/4 0004 9:33
 */
public class PluginResources extends Resources {
    /**
     * Create a new Resources object on top of an existing set of assets in an
     * AssetManager.
     *
     * @param assets  Previously created AssetManager.
     * @param metrics Current display metrics to consider when
     *                selecting/computing resource values.
     * @param config  Desired device configuration to consider when
     */
    public PluginResources(AssetManager assets, DisplayMetrics metrics, Configuration config) {
        super(assets, metrics, config);
    }

    public static AssetManager getAssetManager(File file, Resources resources) {
        //反射获得AssetManager
        try {
            Class<?> c = Class.forName("android.content.res.AssetManager");
            Method[] methods = c.getDeclaredMethods();

            for (Method m : methods) {
                if (m.getName().equals("addAssetPath")) {

                    AssetManager assetManager = AssetManager.class.newInstance();
                    m.invoke(assetManager, file.getAbsolutePath());
                    return assetManager;
                }

            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @title: PluginResources
     * @description: todo
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2017/6/4 0004 9:42
     */
    public static PluginResources getPluginResources(Resources r, AssetManager m) {
        return new PluginResources(m, r.getDisplayMetrics(), r.getConfiguration());
    }
}
