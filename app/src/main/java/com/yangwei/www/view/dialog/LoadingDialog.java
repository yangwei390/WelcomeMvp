package com.yangwei.www.view.dialog;

import android.app.Dialog;
import android.content.Context;

import com.yangwei.www.R;


/**
 * Created by ____ Bye丶 on 2017/6/1.
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context, R.style.style_common_dialog);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_loading);
        setCanceledOnTouchOutside(false);
    }
}
