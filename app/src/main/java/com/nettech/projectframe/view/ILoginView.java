package com.nettech.projectframe.view;

/**
 * Created by Administrator on 2018/1/10.
 */
public interface ILoginView {
    void loginSuccess(String msg);
    void loginFaile(String msg);
    void codeSendSuccess(String msg);
    void codeSendFailed(String msg);
}
