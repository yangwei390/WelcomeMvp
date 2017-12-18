package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
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
    GridView lvHome;
    @BindView(R.id.srlt_home)
    SmartRefreshLayout srltHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        srltHome.autoRefresh();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        srltHome.setEnableOverScrollBounce(true);
        srltHome.setOnRefreshLoadmoreListener(this);
        lvHome.setAdapter(new HomeAdapter(this));
        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(HomeActivity.this, "20dp转换成px是---" + DensityUtil.dp2px(20.7f), Toast.LENGTH_SHORT).show();
//                Log.e("Test", "20dp转换成px是---" + DeviceUtils.dip2px(getApplicationContext(), 20));
//                DensityUtil densityUtil = new DensityUtil();
//                densityUtil.dip2px(1);
            }
        });
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
