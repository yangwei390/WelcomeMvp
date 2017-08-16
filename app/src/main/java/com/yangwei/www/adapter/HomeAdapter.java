package com.yangwei.www.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yangwei.www.R;

/**
 * Created by yangwei on 2017/8/16.
 */

public class HomeAdapter extends BaseAdapter {
    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_home, null);
        return view;
    }
}
