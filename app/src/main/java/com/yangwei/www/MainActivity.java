package com.yangwei.www;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.contract.HomeContract;
import com.yangwei.www.persenter.HomePersenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements HomeContract.View {
    @BindView(R.id.btn_jump)
    Button btnJump;
    private HomeContract.Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new HomePersenter(this);
        persenter.start();
    }

    @Override
    public void setPersenter(HomeContract.Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void showNetDialog() {
        Toast.makeText(this, "启动完毕", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissNetDialog() {

    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_jump)
    public void onViewClicked() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
