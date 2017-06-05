package com.gaozhd.studydemo.androidup.weixinhongbao;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * @Author: Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: HongbaoService
 * @Description: ${todo}
 * @Date: 2017/5/31 0031 19:31
 */
public class HongbaoService extends AccessibilityService {

    private String[] filter = new String[]{"查看红包", "领取红包", "恭喜发财"};

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo info = event.getSource();
        if (info != null) {
            startClick(info);
        }
    }

    private void startClick(AccessibilityNodeInfo info) {
//        List<AccessibilityNodeInfo> infos = getInfoByText(info);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            for (String text : filter) {
                List<AccessibilityNodeInfo> list = info.findAccessibilityNodeInfosByViewId("com.tencent.mobileqq:id/chat_item_content_layout");
                if (list != null && list.size() > 0) {
                    AccessibilityNodeInfo itemInfo = list.get(list.size() - 1);
                    if ("已拆开".equals(itemInfo.getText())) {
                        continue;
                    } else {
                        itemInfo.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }
                }
            }
        }
    }

    private List<AccessibilityNodeInfo> getInfoByText(AccessibilityNodeInfo info) {
        for (String text : filter) {
            List<AccessibilityNodeInfo> list = info.findAccessibilityNodeInfosByText(text);
            if (list != null && list.size() > 0) {
                AccessibilityNodeInfo itemInfo = list.get(list.size() - 1);
                if ("已拆开".equals(itemInfo.getText())) {
                    continue;
                } else {
                    itemInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
        return null;
    }

    @Override
    public void onInterrupt() {

    }
}
