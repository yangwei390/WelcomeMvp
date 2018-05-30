package com.yangwei.www;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.bean.VersionBean;
import com.yangwei.www.contract.UpdateContract;
import com.yangwei.www.persenter.UpdatePersenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangwei on 2018/5/30.
 */

public class UpdateActivity extends BaseActivity implements UpdateContract.View {
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;

    private UpdateContract.Persenter updatePersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        new UpdatePersenter(this);
        updatePersenter.start();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setPersenter(UpdateContract.Persenter persenter) {
        updatePersenter = persenter;
    }

    @Override
    public void showVersionInfo(VersionBean versionBean) {
        tv1.setText("newAppVersion- " + versionBean.getNewAppVersion());
        tv2.setText("versionName- " + versionBean.getVersionName());
        tv3.setText("versionContent- " + versionBean.getVersionContent());
    }

}
