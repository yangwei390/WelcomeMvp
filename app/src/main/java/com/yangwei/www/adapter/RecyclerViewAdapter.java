package com.yangwei.www.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yangwei.www.R;

import java.util.List;

/**
 * @author ____ Bye丶
 * @Date 2018/10/30
 * @Description RecyclerViewAdapter.
 */
public class RecyclerViewAdapter extends BaseQuickAdapter<String, RecyclerViewAdapter.ViewHolder> {


    public RecyclerViewAdapter(List<String> list) {
        super(R.layout.item_home, list);
    }

    @Override
    protected void convert(RecyclerViewAdapter.ViewHolder helper, String item) {
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    class ViewHolder extends BaseViewHolder {

        public ViewHolder(View view) {
            super(view);
        }
    }
}
