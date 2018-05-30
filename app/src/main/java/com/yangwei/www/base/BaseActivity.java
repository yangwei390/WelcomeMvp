package com.yangwei.www.base;

import android.support.v7.app.AppCompatActivity;

import com.yangwei.www.utils.CommonUiTools;
import com.yangwei.www.view.dialog.LoadingDialog;

/**
 * Created by yangwei on 2017/8/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements INetView {
    private LoadingDialog dialog;
    private BasePersenter basePersenter;

    protected abstract void initView();


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
    }
}
