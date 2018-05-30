package com.yangwei.www.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import com.yangwei.www.utils.GsonUtil;
import com.yangwei.www.utils.LogUtils;
import com.yangwei.www.utils.crypt.AESUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ____ Bye丶 on 2017/3/22.
 */
public class JyHandler extends BaseHandler implements Callback {
    private static final int REFRESH = 0x001;
    private Type type;

    protected static Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH:
                    Map map = (Map) msg.obj;
                    ResponseListener listener = (ResponseListener) map.get("listener");
                    ResultData data = (ResultData) map.get("data");
                    listener.onRefresh(data);
            }
        }
    };

    public Handler getHandler() {
        return handler;
    }

    public JyHandler(Type type) {
        super();
        this.type = type;

    }

    @Override
    public void onFailure(Call call, IOException e) {
        LogUtils.e(e);
        if (isCancel()) {
            return;
        }
        ResultData data = new ResultData();
        data.setRspCode(getErrCode(e));
        onData(data);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (isCancel()) {
            return;
        }
        String resultStr = response.body().string();
        ResultData data = new ResultData();
        try {
            if (isEncrypt) {
                JSONObject encryptObj = new JSONObject(resultStr);
                String encryptStr = encryptObj.optString("data");
                if (TextUtils.isEmpty(encryptStr)) return;
                resultStr = AESUtils.aesDecodeStr(encryptStr, AESUtils.AES_SECRET);
            }
            LogUtils.e("返回数据::" + "HTTP_CODE:" + response.code() + "\n" + "返回json:" + resultStr);
            JSONObject json = new JSONObject(resultStr);
            JSONObject header = json.optJSONObject("header");

            //返回状态 默认"0"为成功
            String rspCode = header.optString("rspCode");
            //错误信息
            String rspMsg = header.optString("rspMsg");
            //时间戳
            String rspTime = header.optString("rspTime");

            data.setRspCode(rspCode);
            data.setRspMsg(rspMsg);
            data.setRspTime(rspTime);

            if (isIntercept && ErrorCode.ERROR_LOGIN_AGAIN.equals(rspCode)) {
                onData(data);
                return;
            }

            if (TextUtils.isEmpty(data.getRspMsg()) || data.getRspMsg().equals("null")) {
                data.setRspMsg("");
            }
            if (json.has("body") && !"".equals(json.getString("body")) && this.type != null) {
                data.setBody(GsonUtil.fromJson(json.getString("body"), this.type));
            } else if (json.has("body") && !"".equals(json.getString("body")) && this.type == null) {
                data.setBody(json.getString("body"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            data.setRspCode(ErrorCode.JSON_ERR);
        }
        onData(data);
    }

    protected void onData(final ResultData data) {
        if (listener != null) {
            Map map = new HashMap();
            map.put("listener", listener);
            map.put("data", data);
            map.put("call", call);
            handler.sendMessage(handler.obtainMessage(REFRESH, map));
        }
    }

    /***
     * 获取错误码
     *
     * @param e
     * @return
     */
    public String getErrCode(Throwable e) {
        String code = "";
        if (e instanceof SocketTimeoutException) {
            //服务器连接超时
            code = ErrorCode.SOCKET_TIME_OUT;
        } else if (e instanceof UnknownHostException) {
            //域名解析错误
            code = ErrorCode.UNKNOW_HOST_ERR;
        } else if (e instanceof ConnectException) {
            code = ErrorCode.CONNECT_ERR;
        } else if (e instanceof SocketException) {
            //网络连接失败
            code = ErrorCode.CONNECT_ERR;
        } else {
            code = ErrorCode.SYSTEM_ERR;
        }
        return code;
    }
}
