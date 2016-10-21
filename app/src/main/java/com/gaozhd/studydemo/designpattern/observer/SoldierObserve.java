package com.gaozhd.studydemo.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class SoldierObserve implements Observer {

    public SoldierCallBack mSoldierCallBack = null;
    public String k;

    public interface SoldierCallBack {
        public void refreshTextView(String k);
    }

    public SoldierObserve(String k, SoldierCallBack c) {
        this.k = k;
        mSoldierCallBack = c;
    }

    @Override
    public void update(Observable observable, Object data) {
        if (mSoldierCallBack != null) {
            mSoldierCallBack.refreshTextView(k + " ：" + data.toString());
        }
    }
}
