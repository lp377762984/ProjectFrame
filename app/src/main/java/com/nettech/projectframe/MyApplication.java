package com.nettech.projectframe;

import android.app.Application;

/**
 * Created by Administrator on 2018/1/10.
 */
public class MyApplication extends Application {
    private static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApplication getApp() {
        return app;
    }
}
