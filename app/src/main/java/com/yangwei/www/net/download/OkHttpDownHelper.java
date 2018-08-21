package com.yangwei.www.net.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by ____ Bye丶 on 2016/9/21.
 */

public class OkHttpDownHelper {
    public static OkHttpClient addProgressResponseListener(OkHttpClient client, final ProgressResponseListener listener) {
        //克隆
//        OkHttpClient clone = client.;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //增加拦截器
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response originalResponse = chain.proceed(chain.request());
                //包装响应体并返回
                return originalResponse.newBuilder()
                        .body(new ProgressResponseBody(originalResponse.body(), listener))
                        .build();
            }
        });
//        client1.networkInterceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                //拦截
//                Response originalResponse = chain.proceed(chain.request());
//                //包装响应体并返回
//                return originalResponse.newBuilder()
//                        .body(new ProgressResponseBody(originalResponse.body(), listener))
//                        .build();
//            }
//        });
        OkHttpClient client1 = builder.build();
        return client1;

    }
}
