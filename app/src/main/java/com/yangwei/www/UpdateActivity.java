package com.yangwei.www;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.bean.VersionBean;
import com.yangwei.www.contract.UpdateContract;
import com.yangwei.www.presenter.UpdatePresenter;
import com.yangwei.www.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.btn)
    Button btn;

    private UpdatePresenter updatePersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            // 全屏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_update);
        initView();
        updatePersenter.getNewVersion();
        LogUtils.d("BBBBBB");
    }

    @Override
    public IBasePresenter initPersenter() {
        updatePersenter = new UpdatePresenter(this);
        return updatePersenter;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }


    @Override
    public void showVersionInfo(VersionBean versionBean) {
        tv1.setText("newAppVersion- " + versionBean.getNewAppVersion());
        tv2.setText("versionName- " + versionBean.getVersionName());
        tv3.setText("versionContent- " + versionBean.getVersionContent());
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        toast("开始定位");
    }

}
