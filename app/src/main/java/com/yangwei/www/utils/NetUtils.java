package com.yangwei.www.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.yangwei.www.base.YwApplication;

/**
 * 网络工具类
 * Created by yangwei on 2017/11/6.
 */

public class NetUtils {
    /**
     * 对网络连接状态进行判断
     *
     * @return true, 可用； false， 不可用
     */
    public static boolean isOpenNetwork() {

        ConnectivityManager connManager = (ConnectivityManager) YwApplication.getApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }

        return false;

    }

//    /**
//     * 获取网络请求体中的header部分和h5页面的通用参数
//     *
//     * @param context
//     * @return
//     */
//    public static Map<String, String> getRequestHeader(Context context) {
//        TreeMap headerMap = new TreeMap();
//        headerMap.put("appType", "android");
//        headerMap.put("appNo", ShareData.getShareStringData(ShareData.DEVICEID));
//        headerMap.put("appVersion", DeviceUtils.getCurrentAppVersionName(context));
//        headerMap.put("token", ShareData.getShareStringData(ShareData.USER_TOKEN));
//
//        return headerMap;
//    }
}
