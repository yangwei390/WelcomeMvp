package com.yangwei.www.base;

import android.support.v4.app.Fragment;

import com.yangwei.www.utils.CommonUiTools;

/**
 * Created by yangwei on 2017/8/15.
 */

public class BaseFragment extends Fragment implements IBaseView {

    public void showLoginErrDialog() {
        toast("登录异常");
    }

    @Override
    public void showNetDialog() {

    }

    @Override
    public void dismissNetDialog() {

    }

    public void toast(String str) {
        CommonUiTools.toast(getActivity(), str);
    }
}
