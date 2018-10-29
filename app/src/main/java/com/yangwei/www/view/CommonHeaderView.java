package com.yangwei.www.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.yangwei.www.R;

/**
 * Created by yangwei on 2017/8/23.
 */

public class CommonHeaderView extends LinearLayout implements RefreshHeader {
    private Context context;
    private LottieAnimationView ivHeader;
    private TextView tvHeader;
    private RefreshState mState;

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
        LayoutInflater.from(context).inflate(R.layout.layout_custom_header, this);
        ivHeader = findViewById(R.id.iv_header);
        tvHeader = findViewById(R.id.tv_header);
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
        if (mState == RefreshState.Refreshing) {
            return;
        }
        if (percent <= 0) {
            percent = 0f;
        } else if (percent >= 1) {
            percent = 1f;
        }
        ivHeader.animate().scaleX(percent).setDuration(0);
        ivHeader.animate().scaleY(percent).setDuration(0);
        tvHeader.animate().alpha(percent).setDuration(0);
        tvHeader.animate().scaleX(percent).setDuration(0);
        tvHeader.animate().scaleY(percent).setDuration(0);
        ivHeader.setProgress(percent);
    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {
    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {
        ivHeader.playAnimation();
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        ivHeader.cancelAnimation();
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
        mState = newState;
        switch (newState) {
            case PullDownToRefresh:
                tvHeader.setText("下拉刷新");
                break;
            case ReleaseToRefresh:
                tvHeader.setText("松开刷新");
                break;
            case Refreshing:
            case RefreshReleased:
                tvHeader.setText("正在刷新");
            default:
        }
    }
}
