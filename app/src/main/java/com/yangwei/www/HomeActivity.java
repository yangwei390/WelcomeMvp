package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.yangwei.www.adapter.HomeAdapter;
import com.yangwei.www.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangwei on 2017/8/16.
 */

public class HomeActivity extends BaseActivity implements OnRefreshLoadmoreListener {

    @BindView(R.id.lv_home)
    ListView lvHome;
    @BindView(R.id.srlt_home)
    SmartRefreshLayout srltHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        srltHome.setOnRefreshLoadmoreListener(this);
        lvHome.setAdapter(new HomeAdapter(this));
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        Toast.makeText(this, "加载更多", Toast.LENGTH_SHORT).show();
        srltHome.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                srltHome.finishLoadmore();
            }
        }, 3000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        Toast.makeText(this, "头部刷新", Toast.LENGTH_SHORT).show();
        srltHome.getLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                srltHome.finishRefresh();
            }
        }, 3000);
    }
}
