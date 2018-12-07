package com.yangwei.www.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

import com.yangwei.www.R;

/**
 * @author ____ Bye丶
 * @Date 2018/11/15
 * @Description HomeTipsDialog.
 */
public class HomeTipsDialog extends Dialog {
    public HomeTipsDialog(@NonNull Context context) {
        super(context, R.style.style_common_dialog);
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_home_tips);
        TextView tv = findViewById(R.id.tv_content);
        tv.setMovementMethod(ArrowKeyMovementMethod.getInstance());
        WindowManager manager = this.getWindow().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        this.getWindow().setLayout((int) (width * 0.7), (int) (height * 0.7));
    }
}
