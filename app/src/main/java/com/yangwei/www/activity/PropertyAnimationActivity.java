package com.yangwei.www.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yangwei
 * @Date 2018/8/15
 * @Description 属性动画Activity.
 */
public class PropertyAnimationActivity extends BaseActivity {

    @BindView(R.id.iv_1)
    ImageView iv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_anim);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.iv_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_1:
//                iv1.animate().translationX(500);
                iv1.animate().translationXBy(100).setDuration(1000).setInterpolator(new AnticipateInterpolator());
//                iv1.animate().translationX(500);
                break;
            case R.id.btn:
                break;
            default:
        }
    }
}
