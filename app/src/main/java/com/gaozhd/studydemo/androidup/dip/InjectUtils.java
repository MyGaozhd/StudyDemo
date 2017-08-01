package com.gaozhd.studydemo.androidup.dip;

import android.app.Activity;
import android.view.View;

import com.gaozhd.studydemo.R;

import java.lang.reflect.Field;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: InjectUtils
 * @Description: ${todo}
 * @Date: 2017/6/22 0022 16:30
 */
public class InjectUtils {

    /**
     * @title: inJect
     * @description: todo
     * @author: Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date: 2017/6/22 0022 16:32
     */
    public static void inJect(Activity activity) {
        inJectLayout(activity);
        inJectViews(activity);
    }

    private static void inJectLayout(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView == null)
            return;
        int id = contentView.value();
        activity.setContentView(id);
    }

    private static void inJectViews(Activity activity) {

        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            ViewInject viewInject = f.getAnnotation(ViewInject.class);
            if (viewInject != null) {
                int id = viewInject.value();
                View view = activity.findViewById(id);
                try {
                    f.setAccessible(true);
                    f.set(activity, view);
                } catch (Exception e) {

                }
            }
        }
    }
}
