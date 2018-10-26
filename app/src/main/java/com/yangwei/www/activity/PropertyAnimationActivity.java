package com.yangwei.www.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

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
    @BindView(R.id.tv_hanzi)
    TextView tvHanzi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_anim);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {
//        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
//        tvHanzi.setText(PinYin.getPinYin("重庆"));
        tvHanzi.setText("" + "a".toUpperCase());
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.iv_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_1:
//                iv1.animate().translationXBy(100).setDuration(1000).setInterpolator(new AnticipateInterpolator());
//                iv1.animate().rotationX(360);
//                iv1.animate().rotationBy(360);
//                iv1.animate().alpha(300);
                iv1.animate().setDuration(0);
                iv1.animate().scaleX(-1);
                break;
            case R.id.btn:
                break;
            default:
        }
    }
}
