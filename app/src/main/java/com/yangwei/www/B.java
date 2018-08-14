package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.utils.LogUtils;

/**
 * Created by yangwei on 2018/7/12.
 */

public class B extends BaseActivity {
    public static final String ACTION_A = "com.yangwei.www.BBB_toast";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("Activity------ onCreate");
        setContentView(R.layout.activity_b);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("Activity------ onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("Activity------ onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e("Activity------ onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e("Activity------ onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("Activity------ onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e("Activity------ onDestroy");
    }

    @Override
    protected void initView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.lt_fragment, new BFragment());
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

}
