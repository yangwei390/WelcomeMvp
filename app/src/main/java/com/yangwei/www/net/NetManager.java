package com.yangwei.www.net;

import android.content.Context;
import android.text.TextUtils;

import com.yangwei.www.utils.GsonUtil;
import com.yangwei.www.utils.LogUtils;
import com.yangwei.www.utils.StringUtils;
import com.yangwei.www.utils.crypt.AESUtils;
import com.yangwei.www.utils.crypt.Md5Util;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by ____ Bye丶 on 2017/3/23.
 */
public class NetManager {
    public final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client;
    private OkHttpClient.Builder mBuilder;
    private int connectTime = 30;
    private int readTime = 30;
    private int writeTime = 30;

    public NetManager() {
        if (client == null) {
            synchronized (NetManager.class) {
                if (client == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(false)
                            .connectTimeout(connectTime, TimeUnit.SECONDS)
                            .readTimeout(readTime, TimeUnit.SECONDS)
                            .writeTimeout(writeTime, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES));
                    client = builder.build();
                }
            }
        }
    }

    /***
     * get请求
     *
     * @param params   请求参数
     * @param callback 回调方法
     * @return call 请求句柄
     */
    public Call get(RequestParams params, Callback callback) {
        if (params == null) {
            return null;
        }
        LogUtils.e("请求链接是：" + StringUtils.getQueryUrl(params.getUrl(), params == null ? null : params.getParams()));
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(StringUtils.getQueryUrl(params.getUrl(), params.getParams()));
        if (params.getTag() != 0) {
            requestBuilder.tag(params.getTag());
        }
        if (params.getHeaders() != null) {
            for (Map.Entry<String, String> entry : params.getHeaders().entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Request request = requestBuilder.build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    /***
     * post请求
     *
     * @param params   请求参数
     * @param callback 回调方法
     * @return call 请求句柄
     */
    public Call post(RequestParams params, Callback callback) {
        if (params == null) {
            return null;
        }
        LogUtils.e("请求链接是：" + StringUtils.getQueryUrl(params.getUrl(), params == null ? null : params.getParams()));
        Request.Builder requestBuilder = new Request.Builder().url(params.getUrl());
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (params.getTag() != 0) {
            requestBuilder.tag(params.getTag());
        }
        if (params.getHeaders() != null) {
            for (Map.Entry<String, String> entry : params.getHeaders().entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, Object> entry : params.getParams().entrySet()) {
            try {
                bodyBuilder.addEncoded(URLEncoder.encode(entry.getKey(), "utf-8"), URLEncoder.encode(entry.getValue() + "", "utf-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Request request = requestBuilder.post(bodyBuilder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    /***
     * 上传请求
     *
     * @param params   请求参数
     * @param callback 回调方法
     * @return call 请求句柄
     */
    public Call upload(RequestParams params, Callback callback) {
        if (params == null) {
            return null;
        }
        LogUtils.e("请求链接是：" + StringUtils.getQueryUrl(params.getUrl(), params == null ? null : params.getParams()));
        Request.Builder requestBuilder = new Request.Builder().
                url(params.getUrl());
        MultipartBody.Builder requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        if (params.getTag() != 0) {
            requestBuilder.tag(params.getTag());
        }
        if (params.getHeaders() != null) {
            for (Map.Entry<String, String> entry : params.getHeaders().entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry : params.getParams().entrySet()) {
            try {
                File file = new File(entry.getValue() + "");
                RequestBody fileBody;
                fileBody = RequestBody.create(MediaType.parse(params.getContentType()), file);
                requestBody.addFormDataPart(params.getFormName(), entry.getKey(), fileBody);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Request request = requestBuilder.post(requestBody.build()).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public Call postJson(RequestParams params, Callback callback) {
        if (params == null) {
            return null;
        }
        String requestJson = handleParam(params);
        Request.Builder requestBuilder = new Request.Builder().url(params.getUrl());
        RequestBody body = RequestBody.create(JSON, requestJson);
        requestBuilder.post(body);
        if (params.getTag() != 0) {
            requestBuilder.tag(params.getTag());
        }
        if (params.getHeaders() != null) {
            for (Map.Entry<String, String> entry : params.getHeaders().entrySet()) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        Request request = requestBuilder.build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public static String getGetUrl(Context context, RequestParams params) {
        if (params == null) {
            return "";
        }
        return StringUtils.getQueryUrl(params.getUrl(), params.getParams());
    }

    private String handleParam(RequestParams params) {
        Map bodyMap = params.getParams();
        TreeMap requestMap = new TreeMap();
//        TreeMap headerMap = (TreeMap) NetUtils.getRequestHeader(context);
        TreeMap headerMap = new TreeMap();
        headerMap.put("sign", Md5Util.MD5(GsonUtil.toJson(bodyMap)));
        headerMap.put("requestId", UUID.randomUUID().toString());
        requestMap.put("header", headerMap);
        requestMap.put("body", bodyMap);
        String requestJson = GsonUtil.toJson(requestMap);
        LogUtils.e("请求参数加密前--" + params.getUrl() + requestJson);
        if (params.isEncrypt()) {
            TreeMap encryptMap = new TreeMap();
            encryptMap.put("data", AESUtils.aesEncryptStr(requestJson, AESUtils.AES_SECRET));
            String encryptJson = GsonUtil.toJson(encryptMap);
            LogUtils.e("请求参数加密--" + params.getUrl() + encryptJson);
            return TextUtils.isEmpty(encryptJson) ? "" : encryptJson;
        }
        return TextUtils.isEmpty(requestJson) ? "" : requestJson;
    }

    private static void addUA(Context context, Map map) {
//        if (map == null) {
//            return;
//        }
//        if (UA == null) {
//            UA = new HashMap<>();
//        }
//        UA.clear();
//        UA.put("from", "android");
//        UA.put("imei", DeviceUtils.getPhoneUID(context));
//        UA.put("version", DeviceUtils.getCurrentAppVersionCode(context) + "");
//        UA.put("timestamp", System.currentTimeMillis() + "");
//        String channel=DeviceUtils.getChannel(context);
//        if("SPI".equals(channel)){
//            UA.put("channel", "");
//        }else {
//            UA.put("channel", DeviceUtils.getChannel(context));
//        }

//        if(!StringUtils.isEmpty(UserUtils.getSessionId())){
//            UA.put("token", UserUtils.getSessionId());
//        }
//        map.putAll(UA);
    }

    public void setConnectTime(int connectTime) {
        client = getNewBuilder().retryOnConnectionFailure(false).connectTimeout(connectTime, TimeUnit.SECONDS)
                .readTimeout(connectTime, TimeUnit.SECONDS)
                .writeTimeout(connectTime, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).build();
    }

    public void setDefaultTime() {
        client = getNewBuilder().retryOnConnectionFailure(false).connectTimeout(connectTime, TimeUnit.SECONDS)
                .readTimeout(readTime, TimeUnit.SECONDS)
                .writeTimeout(writeTime, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).build();
    }

    private OkHttpClient.Builder getNewBuilder() {
        if (mBuilder == null) {
            mBuilder = client.newBuilder();
        }
        return mBuilder;
    }

    public OkHttpClient getClient() {
        if (mBuilder == null) {
            return client;
        } else {
            return mBuilder.build();
        }
    }
}
