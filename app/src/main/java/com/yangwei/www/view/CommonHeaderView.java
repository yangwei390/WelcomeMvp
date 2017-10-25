package com.yangwei.www.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * Created by yangwei on 2017/8/23.
 */

public class CommonHeaderView extends LinearLayout implements RefreshHeader {
    private Context context;
    private TextView textView;

    public CommonHeaderView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CommonHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CommonHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dp2px(80)));
        this.setGravity(Gravity.CENTER);
        textView = new TextView(context);
        textView.setText("默认");
        this.addView(textView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
        setVisibility(GONE);
        Log.e("Test","------------------------------onPullingDown");
    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
        textView.setText("刷新准备好");
        Log.e("Test","------------------------------onReleasing");
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return null;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {
        textView.setText("开始动画");
        this.setVisibility(VISIBLE);
        Log.e("Test","------------------------------onStartAnimator");
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        Log.e("Test","------------------------------onFinish");
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}
