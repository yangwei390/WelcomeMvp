package com.yangwei.www.net;

import android.content.Context;

import com.yangwei.www.utils.NetUtils;

import java.io.IOException;
import java.net.ConnectException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ____ Bye丶 on 2017/3/22.
 */
public class BaseHandler implements Callback {
    protected NetManager manager;
    protected ResponseListener listener;
    protected Call call;
    protected boolean isEncrypt;
    protected boolean isIntercept;
    private boolean cancel;

    public BaseHandler() {
        manager = new NetManager();
    }

    public Call start(RequestParams params, ResponseListener listener) {
        if (params == null) {
            return null;
        }
        this.listener = listener;
        this.isEncrypt = params.isEncrypt();
        this.isIntercept = params.isIntercept();
        if (!hasNet()) {
            return null;
        }
        //设置自定义超时时间
        if (params.getConnectTime() != -1) {
            manager.setConnectTime(params.getConnectTime());
        }
        switch (params.getHttpType()) {
            case GET:
                call = manager.get(params, this);
                break;
            case POST:
                call = manager.post(params, this);
                break;
            case UPLOAD:
                call = manager.upload(params, this);
                break;
            case POSTJSON:
                call = manager.postJson(params, this);
                break;
        }
        if (params.getConnectTime() != -1) {
            manager.setDefaultTime();
        }
        return call;
    }

    private boolean hasNet() {
        if (!NetUtils.isOpenNetwork()) {
            onFailure(call, new ConnectException(""));
            return false;
        }
        return true;

    }

    public void cancel() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
        cancel = true;
    }

    public boolean isCancel() {
        return cancel;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        call = null;
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        call = null;
    }
}
