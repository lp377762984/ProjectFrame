package com.nettech.projectframe;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.RestRequest;

/**
 * Created by 李平 on 2017/8/11.
 * 网络队列(单例)
 */

public class CallServer {

    private static CallServer instance;

    public static CallServer getInstance() {
        if (instance == null)
            synchronized (CallServer.class) {
                if (instance == null)
                    instance = new CallServer();
            }
        return instance;
    }

    private RequestQueue requestQueue;

    private CallServer() {
        requestQueue = NoHttp.newRequestQueue();
    }

    public void addRequest(int what, RestRequest<String> request, OnResponseListener<String> listener) {
        requestQueue.add(what, request, listener);
    }

    // 完全退出app时，调用这个方法释放CPU。
    public void stop() {
        if (requestQueue != null) {
            requestQueue.stop();
        }
    }
    public void cancelBySign(Object sign) {
        if (requestQueue != null) {
            requestQueue.cancelBySign(sign);
        }
    }
}