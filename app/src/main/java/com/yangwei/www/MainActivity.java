package com.yangwei.www;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.edt_test)
    EditText edtTest;
    private HomeContract.Persenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new HomePersenter(this);
        persenter.start();
        ivSearch.setImageResource(R.drawable.loading);
        initView();
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
        edtTest.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    Toast.makeText(MainActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.btn_jump)
    public void onViewClicked() {
        startActivity(new Intent(this, WaterfallActivity.class));
//        Drawable drawable = ivSearch.getDrawable();
//        if (drawable instanceof Animatable) {
//            ((Animatable) drawable).start();
//        }
//        ivSearch.setImageResource(R.drawable.loading);
//        AnimationDrawable animationDrawable = (AnimationDrawable) ivSearch.getDrawable();
//        animationDrawable.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
