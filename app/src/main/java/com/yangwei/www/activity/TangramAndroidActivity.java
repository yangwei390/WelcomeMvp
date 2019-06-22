package com.yangwei.www.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.TangramEngine;
import com.tmall.wireless.tangram.util.IInnerImageSetter;
import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author yangwei
 * @Date 2019/5/13
 * @Description TangramAndroidActivity
 */
public class TangramAndroidActivity extends BaseActivity {

    @BindView(R.id.rv_tangram)
    RecyclerView rvTangram;
    @BindView(R.id.vp_tangram)
    ViewPager vpTangram;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tangram);
        initView();
    }


    @Override
    protected void initView() {
        ButterKnife.bind(this);

        TangramBuilder.init(this, new IInnerImageSetter() {
            @Override
            public <IMAGE extends ImageView> void doLoadImageUrl(@NonNull IMAGE view,
                                                                 @Nullable String url) {
            }
        }, ImageView.class);

        TangramBuilder.InnerBuilder builder = TangramBuilder.newInnerBuilder(TangramAndroidActivity.this);

        TangramEngine engine = builder.build();
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    class Adapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }
}
