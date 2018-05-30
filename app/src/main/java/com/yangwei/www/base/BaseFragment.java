package com.yangwei.www.base;

import android.support.v4.app.Fragment;

import com.yangwei.www.utils.CommonUiTools;

/**
 * Created by yangwei on 2017/8/15.
 */

public class BaseFragment extends Fragment {

    public void showLoginErrDialog() {
        toast("登录异常");
    }

    public void toast(String str) {
        CommonUiTools.toast(getActivity(), str);
    }
}
