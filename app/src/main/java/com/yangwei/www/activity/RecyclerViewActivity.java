package com.yangwei.www.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.yangwei.www.R;
import com.yangwei.www.adapter.RecyclerViewAdapter;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.view.JYRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ____ Bye丶
 * @Date 2018/10/30
 * @Description RecyclerViewActivity.
 */
public class RecyclerViewActivity extends BaseActivity implements JYRecyclerView.OnRefreshLoadMoreListener {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.jyr_v)
    JYRecyclerView jyrV;

    private int i;

    private RecyclerViewAdapter adapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        jyrV.refresh();
    }

    private List initData() {
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i + "");
        }
        return list;
    }

    private List stopData() {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(i + "");
        }
        return list;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        adapter = new RecyclerViewAdapter(list);
        jyrV.initJYRecyclerView(list, adapter);
        jyrV.setPageSize(5);
        jyrV.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onRefresh(int currentPage) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jyrV.refreshFinish();
                jyrV.notifyDataSetChanged(initData());
            }
        }, 3000);
    }

    @Override
    public void onLoadMore(int currentPage) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                i++;
                jyrV.refreshFinish();
                if (i >= 3) {
                    jyrV.notifyDataSetChanged(stopData());
                } else {
                    jyrV.notifyDataSetChanged(initData());
                }
            }
        }, 3000);
    }
}
