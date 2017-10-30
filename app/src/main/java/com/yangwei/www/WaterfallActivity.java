package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yangwei.www.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 瀑布了activity
 * Created by yangwei on 2017/10/25.
 */

public class WaterfallActivity extends BaseActivity implements OnRefreshListener, OnLoadmoreListener {

    @BindView(R.id.tv_click)
    TextView tvClick;
    @BindView(R.id.rv_water)
    RecyclerView rvWater;
    @BindView(R.id.srlt_water)
    SmartRefreshLayout srltWater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
//        srltWater
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {

    }

    @OnClick({R.id.tv_click, R.id.rv_water, R.id.srlt_water})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_click:
                break;
            case R.id.rv_water:
                break;
            case R.id.srlt_water:
                break;
        }
    }
}
