package com.yangwei.www.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ____ Bye丶
 * @Date 2018/10/26
 * @Description CustomHeadeRefreshActivity.
 */
public class CustomHeadeRefreshActivity extends BaseActivity implements OnRefreshListener {


    @BindView(R.id.srlt_)
    SmartRefreshLayout srlt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_heade_refresh);
        initView();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        srlt.setOnRefreshListener(this);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                srlt.finishRefresh();
            }
        }).start();
    }
}
