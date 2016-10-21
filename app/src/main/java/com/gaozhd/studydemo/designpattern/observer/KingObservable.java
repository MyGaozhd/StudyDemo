package com.gaozhd.studydemo.designpattern.observer;

import java.util.Observable;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class KingObservable extends Observable {

    private String afterK = "";

    public void setChange(String afterK) {
        if (!this.afterK.equals(afterK)) {
            setChanged();
            notifyObservers(afterK);
        }
    }
}
