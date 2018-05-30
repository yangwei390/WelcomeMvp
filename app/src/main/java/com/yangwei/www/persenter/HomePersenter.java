package com.yangwei.www.persenter;

import android.util.Log;

import com.yangwei.www.base.BasePersenter;
import com.yangwei.www.contract.HomeContract;
import com.yangwei.www.net.RequestParams;
import com.yangwei.www.net.ResponseListener;
import com.yangwei.www.net.ResultData;
import com.yangwei.www.net.UrlConfig;

/**
 * Created by yangwei on 2017/8/16.
 */

public class HomePersenter extends BasePersenter implements HomeContract.Persenter {
    private HomeContract.View view;

    public HomePersenter(HomeContract.View view) {
        view.setPersenter(this);
        this.view = view;
        baseView = view;
    }

    @Override
    public void start() {
        Log.e("Test", "111111111111111111111111");
        view.showNetDialog();

    }

}
