package com.yangwei.www.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.yangwei.www.R;

/**
 * @author ____ Bye丶
 * @Date 2018/10/29
 * @Description CommonFooterView.
 */
public class CommonFooterView extends LinearLayout implements RefreshFooter {
    private Context context;
    private LinearLayout ltLoading;
    private ImageView ivLoading;
    private TextView tvNoData;
    protected boolean mNoMoreData = false;

    public CommonFooterView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CommonFooterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CommonFooterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.layout_common_footer, this);
        ltLoading = findViewById(R.id.lt_loading);
        ivLoading = findViewById(R.id.iv_loading);
        tvNoData = findViewById(R.id.tv_no_data);
        ivLoading.animate().setInterpolator(new LinearInterpolator());
    }

    @Override
    public boolean setNoMoreData(boolean noMoreData) {
        if (mNoMoreData != noMoreData) {
            mNoMoreData = noMoreData;
            if (noMoreData) {
                ltLoading.setVisibility(GONE);
                tvNoData.setVisibility(VISIBLE);
            } else {
                ltLoading.setVisibility(VISIBLE);
                tvNoData.setVisibility(GONE);
            }
        }
        return true;
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {
        ivLoading.animate().rotation(36000).setDuration(100000);
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        ivLoading.animate().rotation(0).setDuration(300);
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}
