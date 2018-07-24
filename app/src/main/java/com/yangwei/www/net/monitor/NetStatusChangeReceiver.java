package com.yangwei.www.net.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yangwei on 2018/7/12.
 */

public class NetStatusChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            NetObservable.getInstance().notifNetChange(NetType.NO_NET);
            return;
        }
        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        NetObservable.getInstance().notifNetChange(isWiFi ? NetType.WIFI : NetType.MOBILE_NET);
    }
}
