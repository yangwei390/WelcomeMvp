package com.yangwei.www.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yangwei on 2017/8/16.
 */

public interface IBaseView {
    void showNetDialog();

    void dismissNetDialog();

    void toast(String str);

    void goPage(Class<? extends Activity> clas);

    void goPage(Class<? extends Activity> clas, Bundle data);

    void goPage(Class<? extends Activity> clas, Bundle data, int requestCode);

    String getBundleStr(String key);

    Bundle getIntentData();
}
