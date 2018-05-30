package com.yangwei.www.base;

import android.app.Application;

/**
 * Created by yangwei on 2018/5/30.
 */

public class YwApplication extends Application {
    public static YwApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static YwApplication getApplication() {
        return baseApplication;
    }

}
