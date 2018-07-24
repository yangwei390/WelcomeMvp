package com.yangwei.www.base;

import android.app.Application;
import android.content.IntentFilter;

import com.yangwei.www.net.monitor.NetStatusChangeReceiver;

/**
 * Created by yangwei on 2018/5/30.
 */

public class YwApplication extends Application {
    public static YwApplication baseApplication;
    private NetStatusChangeReceiver netStatusChangeReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        registerNetListener();
    }

    private void registerNetListener() {
        netStatusChangeReceiver = new NetStatusChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netStatusChangeReceiver, intentFilter);
    }

    private void unRegisterNetListener() {
        if (netStatusChangeReceiver != null) {
            unregisterReceiver(netStatusChangeReceiver);
        }
    }

    public static YwApplication getApplication() {
        return baseApplication;
    }

}
