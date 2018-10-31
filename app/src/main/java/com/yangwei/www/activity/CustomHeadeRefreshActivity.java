package com.yangwei.www.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yangwei.www.R;
import com.yangwei.www.adapter.HomeAdapter;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.view.CommonFooterView;
import com.yangwei.www.view.CommonRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ____ Bye丶
 * @Date 2018/10/26
 * @Description CustomHeadeRefreshActivity.
 */
public class CustomHeadeRefreshActivity extends BaseActivity implements OnRefreshLoadMoreListener {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.srlt_)
    CommonRefreshLayout srlt;
    @BindView(R.id.lv_refresh)
    ListView lvRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_heade_refresh);
        initView();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        lvRefresh.setAdapter(new HomeAdapter(this));
        srlt.setOnRefreshLoadMoreListener(this);
//        srlt.setNoMoreData(true);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                srlt.finishLoadMore();
                srlt.setNoMoreData(true);
            }
        }, 3000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                srlt.finishRefresh();
                srlt.setNoMoreData(false);
            }
        }, 3000);
    }
}
