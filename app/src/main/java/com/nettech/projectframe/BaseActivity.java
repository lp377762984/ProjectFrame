package com.nettech.projectframe;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.RestRequest;
import com.yanzhenjie.nohttp.rest.StringRequest;


public class BaseActivity extends AppCompatActivity {
    //当前页面的网络请求的tag,用于结束页面所有网络请求
    private Object mRequestSign = new Object();
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private StringRequest buildRequest(String url, RequestMethod method, boolean needCache) {
        StringRequest request = new StringRequest(url, method);
        request.setCacheMode(needCache ? CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE : CacheMode.DEFAULT);
        request.setCancelSign(mRequestSign);
        return request;
    }

    private void doNetwork(int what, final String msg, final RestRequest<String> request) {
        CallServer.getInstance().addRequest(what, request, new OnResponseListener<String>() {
            private ProgressDialog dialog;

            @Override
            public void onStart(int what) {
                if (msg != null) {
                    dialog = new ProgressDialog(BaseActivity.this);
                    dialog.show();
                }
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                mHandle200(what,response.get());
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                mHandleFailed(what,response.getException());
            }

            @Override
            public void onFinish(int what) {
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CallServer.getInstance().cancelBySign(mRequestSign);
    }

    private void mHandle200(int what, String data) {
        Log.d(TAG, "mHandle200: "+data);
    }

    private void mHandleFailed(int what, Exception e) {
        Log.e(TAG, "mHandleFailed: " + e.getMessage());
    }
}
