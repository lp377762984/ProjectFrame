package com.nettech.projectframe.utils;

import android.widget.Toast;
import com.nettech.projectframe.MyApplication;

/**
 * Created by Administrator on 2018/1/10.
 */
public class XToast {
    private static Toast mToast;

    public static void show(CharSequence text) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(MyApplication.getApp(), text, Toast.LENGTH_LONG);
        mToast.show();
    }
}
