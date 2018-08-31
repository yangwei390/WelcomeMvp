package com.yangwei.www.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.base.YwApplication;
import com.yangwei.www.view.CustomWebView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ____ Bye丶
 * @Date 2018/8/31
 * @Description 通用Web展示页面.
 */
public class CommonWebActivity extends BaseActivity {

    @BindView(R.id.flt_web)
    FrameLayout fltWeb;

    private CustomWebView customWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_web);
        initView();
        customWebView.getmWebView().loadUrl("http://www.taobao.com");
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        customWebView = new CustomWebView(YwApplication.getApplication());
        fltWeb.addView(customWebView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customWebView.getmWebView().removeAllViews();
        customWebView.getmWebView().destroy();
        customWebView.removeAllViews();
        fltWeb.removeAllViews();
    }
}
