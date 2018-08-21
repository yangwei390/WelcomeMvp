package com.yangwei.www.net.upload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ____ Bye丶 on 2017/5/20.
 */

public class OkHttpUpLoad {
    private static OkHttpUpLoad okHttpUpload;
    private Handler mainHanlder;
    public OkHttpClient mOkHttpClient;
    public Gson gson;
    private int connectTime = 150;
    private int readTime = 200;
    private int writeTime = 200;

    private OkHttpUpLoad() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(connectTime, TimeUnit.SECONDS)
                .readTimeout(readTime, TimeUnit.SECONDS)
                .writeTimeout(writeTime, TimeUnit.SECONDS).connectionPool(new ConnectionPool(5, 1, TimeUnit.MINUTES)).retryOnConnectionFailure(false);
        mOkHttpClient = builder.build();
        gson = new Gson();

        //更新UI线程
        mainHanlder = new Handler(Looper.getMainLooper());
    }

    public static OkHttpUpLoad getInstance() {
        synchronized (OkHttpUpLoad.class) {
            if (okHttpUpload == null) {
                okHttpUpload = new OkHttpUpLoad();
            }
        }
        return okHttpUpload;
    }

    public void startUpLoad(Context context, String url, RequestBody requestBody,
                            MyCallBack myCallBack, final UIchangeListener uIchangeListener) {
        ProgressRequestBody progressRequestBody = ProgressHelper.addProgressRequestListener(requestBody, new UIProgressRequestListener() {
            @Override
            public void onUIRequestProgress(long bytesWrite, long contentLength, boolean done) {
                uIchangeListener.progressUpdate(bytesWrite, contentLength, done);
            }
        });

        Request request = new Request.Builder()
                .tag(context)
                .post(progressRequestBody)
                .url(url)
                .build();

        postData2Server(request, myCallBack);
    }

    /**
     * 异步回调方式 post请求  自定义回调接口  结果运行在UI线程
     * json 也可以
     *
     * @param request
     * @throws Exception
     */
    public void postData2Server(Request request, final MyCallBack myCallBack) {
        try {
            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    myCallBack.onFailure(call.request(), e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        final String json = response.body().string();

                        mainHanlder.post(new Runnable() {
                            @Override
                            public void run() {
                                myCallBack.onResponse(json);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface MyCallBack {
        void onFailure(Request request, IOException e);

        void onResponse(String json);
    }

    public interface UIchangeListener {
        void progressUpdate(long bytesWrite, long contentLength, boolean done);
    }

}
