package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

/**
 * Created by yangwei on 2018/7/12.
 */

public class B extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }
}
