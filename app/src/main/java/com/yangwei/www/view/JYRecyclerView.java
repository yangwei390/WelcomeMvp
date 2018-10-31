package com.yangwei.www.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yangwei.www.R;

import java.util.List;

/**
 * @author ____ Bye丶
 * @Date 2018/10/31
 * @Description JYRecyclerView.
 */
public class JYRecyclerView extends LinearLayout implements OnRefreshLoadMoreListener {
    private Context context;
    private RecyclerView rv;
    private SmartRefreshLayout srltRv;
    private BaseQuickAdapter adapter;
    private List list;
    private OnRefreshLoadMoreListener onRefreshLoadMoreListener;
    private View footerView;
    /**
     * 当前查询页码
     */
    private int currentPage = 1;
    /**
     * 每页获取多少条数据
     */
    private int pageSize = 20;
    /**
     * 是否下拉刷新
     */
    private boolean isRefresh;

    public JYRecyclerView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public JYRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public JYRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public JYRecyclerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.layout_jy_recyclerview, this);
        srltRv = findViewById(R.id.smrt_rv);
        srltRv.setEnableOverScrollBounce(false);
        srltRv.setOnRefreshLoadMoreListener(this);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    public void initJYRecyclerView(List list, BaseQuickAdapter adapter) {
        this.list = list;
        this.adapter = adapter;
        rv.setAdapter(this.adapter);
    }

    public void refresh() {
        srltRv.autoRefresh();
    }

    public void refreshFinish() {
        srltRv.finishLoadMore();
        srltRv.finishRefresh();
    }

    public void notifyDataSetChanged(List list) {
        if (this.list == null || this.adapter == null || list == null) {
            return;
        }
        if (isRefresh) {
            this.list.clear();
        }
        this.list.addAll(list);
        currentPage++;
        adapter.notifyDataSetChanged();
//        adapter.setNewData(this.list);
//        adapter.addData(list);
        setNoMoreData(list.size() < pageSize);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        if (onRefreshLoadMoreListener != null) {
            isRefresh = false;
            onRefreshLoadMoreListener.onLoadMore(currentPage);
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        if (onRefreshLoadMoreListener != null) {
            currentPage = 1;
            isRefresh = true;
            onRefreshLoadMoreListener.onRefresh(currentPage);
        }
    }

    private void setNoMoreData(boolean isNoMoerData) {
        if (isNoMoerData) {
            if (footerView != null) {
                return;
            }
            footerView = new CommonFooterView(context);
            ((CommonFooterView) footerView).setNoMoreData(true);
            adapter.addFooterView(footerView);
            srltRv.setEnableLoadMore(false);
        } else {
            if (footerView != null) {
                adapter.removeFooterView(footerView);
                footerView = null;
                srltRv.setEnableLoadMore(true);
            }
        }
    }

    public void setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.onRefreshLoadMoreListener = onRefreshLoadMoreListener;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public RecyclerView getRecyclerView() {
        return rv;
    }

    public SmartRefreshLayout getSmartRefreshLayout() {
        return srltRv;
    }

    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    public interface OnRefreshLoadMoreListener {
        void onRefresh(int currentPage);

        void onLoadMore(int currentPage);
    }
}
