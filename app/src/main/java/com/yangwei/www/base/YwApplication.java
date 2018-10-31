package com.yangwei.www.base;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;

import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.yangwei.www.net.monitor.NetStatusChangeReceiver;
import com.yangwei.www.view.CommonFooterView;
import com.yangwei.www.view.CommonHeaderView;

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
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
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

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new CommonHeaderView(context);
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new CommonFooterView(context);
            }
        });
    }
}
