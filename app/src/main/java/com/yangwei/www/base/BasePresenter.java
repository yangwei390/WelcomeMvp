package com.yangwei.www.base;

import com.yangwei.www.net.HandlerRequestErr;
import com.yangwei.www.net.JyHandler;
import com.yangwei.www.net.RequestParams;
import com.yangwei.www.net.ResponseListener;
import com.yangwei.www.net.ResultData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by yangwei on 2018/5/29.
 */

public class BasePresenter implements IBasePresenter {
    private List<Call> calls;
    protected IBaseView baseView;

    public BasePresenter(IBaseView view) {
        this.baseView = view;
    }

    public boolean handlerRequestErr(ResultData data) {
        return HandlerRequestErr.handlerRequestErr(baseView, data);
    }

    public boolean handlerRequestErr(ResultData data, boolean isTips) {
        return HandlerRequestErr.handlerRequestErr(baseView, data, isTips);
    }

    protected void startRequest(RequestParams params, Type type, ResponseListener responseListener) {
        JyHandler handler = new JyHandler(type);
        Call call = handler.start(params, responseListener);
        addCall(call);
    }

    private void addCall(Call call) {
        if (call == null) {
            return;
        }
        if (calls == null) {
            calls = new ArrayList<>();
        }
        calls.add(call);
    }

    private void cancelCall(Call call) {
        if (calls != null && calls.size() != 0) {
            if (call != null) {
                if (!call.isCanceled()) {
                    call.cancel();
                }
                calls.remove(call);
            } else {
                for (Call cal : calls) {
                    if (cal != null) {
                        cal.cancel();
                    }
                }
            }
            calls.clear();
        }
    }


    @Override
    public void destroy() {
        baseView = null;
        cancelCall(null);
    }
}
