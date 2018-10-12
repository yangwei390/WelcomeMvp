package com.yangwei.www.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yangwei.www.common.Ikeys;
import com.yangwei.www.utils.CommonUiTools;
import com.yangwei.www.view.dialog.LoadingDialog;

/**
 * Created by yangwei on 2017/8/15.
 */

public abstract class BaseActivity extends NetMonitorActivity implements IBaseView, Ikeys {
    private LoadingDialog dialog;
    private IBasePresenter basePresenter;

    protected abstract void initView();

    protected abstract IBasePresenter initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter = initPresenter();
//        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent));
//        ImmersionBar.with(this).init();
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
    public void goPage(Class<? extends Activity> clas) {
        goPage(clas, null);
    }

    @Override
    public void goPage(Class<? extends Activity> clas, Bundle data) {
        goPage(clas, data, -1);
    }

    @Override
    public void goPage(Class<? extends Activity> clas, Bundle data, int requestCode) {
        if (clas == null) {
            return;
        }
        Intent intent = new Intent(this, clas);
        if (data != null) {
            intent.putExtra(KEY_DATA, data);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public String getBundleStr(String key) {
        Bundle bundle = getIntent().getBundleExtra(Ikeys.KEY_DATA);
        if (bundle == null) {
            return "";
        }
        return bundle.getString(key, "");
    }

    @Override
    public Bundle getIntentData() {
        Bundle bundle = getIntent().getBundleExtra(Ikeys.KEY_DATA);
        if (bundle == null) {
            bundle = new Bundle();
        }
        return bundle;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter != null) {
            basePresenter.destroy();
            basePresenter = null;
        }
    }


}
