package com.gaozhd.studydemo.androidbase.mvp;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: LoginP
 * @Description: ${todo}
 * @date 2016/10/12 19:26
 */
public class LoginP {
    private Ilogin ilogin;

    public LoginP(Ilogin ilogin) {
        this.ilogin = ilogin;
    }

    public void login() {

        String un = ilogin.getUn();
        String up = ilogin.getUp();

        //dengluo

        //更新ui

        ilogin.updateUI();
    }
}
