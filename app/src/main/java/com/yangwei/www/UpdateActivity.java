package com.yangwei.www;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.bean.VersionBean;
import com.yangwei.www.contract.UpdateContract;
import com.yangwei.www.presenter.UpdatePresenter;
import com.yangwei.www.utils.LogUtils;
import com.yangwei.www.utils.StatusBarUtil;

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
    @BindView(R.id.edt_1)
    EditText edt1;

    private UpdatePresenter updatePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            // 全屏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setStatusBarColor(this, R.color.white);
        }
        setContentView(R.layout.activity_update);
        initView();
        updatePresenter.getNewVersion();
        LogUtils.d("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    @Override
    public IBasePresenter initPresenter() {
        updatePresenter = new UpdatePresenter(this);
        return updatePresenter;
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            toast(data.getExtras().getString("AAAAAAAA"));
        }
    }
}
