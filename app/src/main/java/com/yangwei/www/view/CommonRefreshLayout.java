package com.yangwei.www.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @author ____ Bye丶
 * @Date 2018/10/30
 * @Description RefreshLayout.
 */
public class CommonRefreshLayout extends SmartRefreshLayout {
    private Context context;
    private View listviewFooterView = null;


    public CommonRefreshLayout(Context context) {
        super(context);
        this.context = context;
    }

    public CommonRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CommonRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    public SmartRefreshLayout setNoMoreData(boolean noMoreData) {
        @SuppressLint("RestrictedApi") View secondView = mRefreshContent.getView();
        if (secondView instanceof ListView) {
            if (noMoreData) {
                listviewFooterView = new CommonFooterView(context);
                ((CommonFooterView) listviewFooterView).setNoMoreData(true);
                ((ListView) secondView).addFooterView(listviewFooterView);
                setEnableLoadMore(false);
            } else {
                ((ListView) secondView).removeFooterView(listviewFooterView);
                listviewFooterView = null;
                setEnableLoadMore(true);
            }
        } else {
            return super.setNoMoreData(noMoreData);
        }
        return this;
    }
}
