package com.yangwei.www.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yangwei.www.net.monitor.NetObservable;
import com.yangwei.www.net.monitor.NetType;
import com.yangwei.www.utils.CommonUiTools;

import java.util.Observable;
import java.util.Observer;

/**
 * 自带网络监控Activity
 * Created by yangwei on 2018/7/17.
 */

public class NetMonitorActivity extends AppCompatActivity implements Observer {
    private boolean isFront = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NetObservable.getInstance().addObserver(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetObservable.getInstance().deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        NetType netType = (NetType) arg;
        if (netType == NetType.NO_NET) {
            CommonUiTools.toast(this, "没有网络");
        } else if (netType == NetType.MOBILE_NET) {
            CommonUiTools.toast(this, "移动网络");
        } else if (netType == NetType.WIFI) {
            CommonUiTools.toast(this, "WIFI");
        }
    }
}
