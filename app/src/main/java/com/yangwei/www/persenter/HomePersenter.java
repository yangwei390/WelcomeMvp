package com.yangwei.www.persenter;

import android.util.Log;

import com.yangwei.www.contract.HomeContract;

/**
 * Created by yangwei on 2017/8/16.
 */

public class HomePersenter implements HomeContract.Persenter {
    private HomeContract.View view;

    public HomePersenter(HomeContract.View view) {
        view.setPersenter(this);
        this.view = view;
    }

    @Override
    public void start() {
        Log.e("Test", "111111111111111111111111");
        view.showNetDialog();
    }

}
