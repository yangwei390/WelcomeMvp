package com.yangwei.www.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangwei.www.common.Ikeys;
import com.yangwei.www.utils.CommonUiTools;
import com.yangwei.www.view.dialog.LoadingDialog;

/**
 * Created by yangwei on 2017/8/15.
 */

public class BaseFragment extends Fragment implements IBaseView, Ikeys {
    private LoadingDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    public void showLoginErrDialog() {
        toast("登录异常");
    }

    @Override
    public void showNetDialog() {
        try {
            if (dialog == null) {
                dialog = new LoadingDialog(getActivity());
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

    public void toast(String str) {
        CommonUiTools.toast(getActivity(), str);
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
        Intent intent = new Intent(getActivity(), clas);
        if (data != null) {
            intent.putExtra(KEY_DATA, data);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public String getBundleStr(String key) {
        return "";
    }

    @Override
    public Bundle getIntentData() {
        return null;
    }
}
