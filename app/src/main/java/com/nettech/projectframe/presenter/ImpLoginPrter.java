package com.nettech.projectframe.presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.nettech.projectframe.utils.XToast;
import com.nettech.projectframe.view.ILoginView;

/**
 * Created by Administrator on 2018/1/10.
 */
public class ImpLoginPrter implements ILoginPrter {
    private ILoginView view;

    public ImpLoginPrter(ILoginView view) {
        this.view = view;
    }

    @Override
    public void login(String phone, String psd) {
        if(TextUtils.isEmpty(phone)){
            XToast.show("请输入手机号码?");
            return;
        }
        //网络请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.loginSuccess("登陆成功");
            }
        },2000);
    }

    @Override
    public void sendCode() {

    }
}
