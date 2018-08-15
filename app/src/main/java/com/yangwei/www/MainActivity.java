package com.yangwei.www;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yangwei.www.activity.MyTextViewActivity;
import com.yangwei.www.activity.UpdateActivity;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.lv_main)
    ListView lvMain;

    private ArrayList<String> mainList = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListView();
    }

    private void setListView() {
        setData();
        adapter = new Adapter();
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            goPage((Class<? extends Activity>) Class.forName(mainList.get(position)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            toast("页面不存在");
        }
    }

    private void setData() {
        mainList.add(MyTextViewActivity.class.getName());
        mainList.add(UpdateActivity.class.getName());
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mainList.size();
        }

        @Override
        public Object getItem(int position) {
            return mainList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String str = mainList.get(position);
            if (str.contains("com.yangwei.www.activity.")) {
                viewHolder.tvMain.setText(str.replace("com.yangwei.www.activity.", ""));
            } else {
                viewHolder.tvMain.setText(str);
            }
            return convertView;
        }

        class ViewHolder {
            @BindView(R.id.tv_main)
            TextView tvMain;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
