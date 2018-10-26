package com.yangwei.www.activity;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author ____ Bye丶
 * @Date 2018/10/18
 * @Description InfoSearchActivity.
 */
public class InfoSearchActivity extends BaseActivity {

    @BindView(R.id.iv_)
    ImageView iv;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_search);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.CHINA);
//        String currentTime = formatter.format(Calendar.getInstance().getTime());
//        tvInfo.setText(Calendar.getInstance().getTime() + "");
        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018, 10, 25, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        calendar.set(2018, 9, 25);
        calendar.add(Calendar.MINUTE, 20);
        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm",Locale.CHINA);
        tvInfo.setText(formatter.format(calendar.getTime()));
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @OnClick(R.id.iv_)
    public void onViewClicked() {
        toast("编辑");
    }
}
