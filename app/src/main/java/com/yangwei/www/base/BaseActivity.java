package com.yangwei.www.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yangwei.www.utils.CommonUiTools;
import com.yangwei.www.view.dialog.LoadingDialog;

/**
 * Created by yangwei on 2017/8/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    private LoadingDialog dialog;
    private IBasePersenter basePersenter;

    protected abstract void initView();

    protected abstract IBasePersenter initPersenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePersenter = initPersenter();
    }

    @Override
    public void toast(String str) {
        CommonUiTools.toast(this, str);
    }

    @Override
    public void showNetDialog() {
        try {
            if (dialog == null) {
                dialog = new LoadingDialog(this);
                dialog.setCanceledOnTouchOutside(false);
            }
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dismissNetDialog() {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showLoginErrDialog() {
        toast("登录异常");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePersenter != null) {
            basePersenter.destroy();
            basePersenter = null;
        }
    }
}
