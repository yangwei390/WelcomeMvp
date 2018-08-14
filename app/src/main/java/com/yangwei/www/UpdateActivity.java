package com.yangwei.www;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.bean.VersionBean;
import com.yangwei.www.contract.UpdateContract;
import com.yangwei.www.presenter.UpdatePresenter;
import com.yangwei.www.utils.DeviceUtils;
import com.yangwei.www.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yangwei on 2018/5/30.
 */

public class UpdateActivity extends BaseActivity implements UpdateContract.View {

    public static final String ACTION_B = "com.yangwei.www.b";


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
    private UpReceiver upReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏设置
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            // 全屏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        //白色状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            StatusBarUtil.setStatusBarColor(this, R.color.white);
//        }
        StatusBarUtil.setTranslucentForImageView(this, null);
        StatusBarUtil.setLightMode(this);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_update);
        initView();
        updatePresenter.getNewVersion();
        A();

    }

    private void A() {
        upReceiver = new UpReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_B);
        registerReceiver(upReceiver, intentFilter);
    }

    @Override
    public IBasePresenter initPresenter() {
        updatePresenter = new UpdatePresenter(this);
        return updatePresenter;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Paint textPaint = tv1.getPaint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(DeviceUtils.dip2px(this, 40));
        textPaint.setStrokeWidth(DeviceUtils.dip2px(this, 1));
        textPaint.setUnderlineText(true);
        tv1.setText("床前明月光");
    }


    @Override
    public void showVersionInfo(VersionBean versionBean) {
        tv1.setText("newAppVersion- " + versionBean.getNewAppVersion());
        tv2.setText("versionName- " + versionBean.getVersionName());
        tv3.setText("versionContent- " + versionBean.getVersionContent());
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        goPage(B.class);
//        String uniqueID = UUID.randomUUID().toString();
//        toast(uniqueID.replaceAll("-", ""));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            toast(data.getExtras().getString("AAAAAAAA"));
        }
    }

    class UpReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_B)) {
                LogUtils.e("Test", "UpdateActivity接收到了广播");
                Intent intent1 = new Intent();
                intent1.setAction(B.ACTION_A);
                context.sendBroadcast(intent1);
            }
        }
    }
}
