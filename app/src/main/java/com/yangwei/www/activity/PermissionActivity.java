package com.yangwei.www.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yangwei.www.R;
import com.yangwei.www.base.BaseActivity;
import com.yangwei.www.base.IBasePresenter;
import com.yangwei.www.view.pickerview.pickerview.builder.TimePickerBuilder;
import com.yangwei.www.view.pickerview.pickerview.listener.OnTimeSelectChangeListener;
import com.yangwei.www.view.pickerview.pickerview.listener.OnTimeSelectListener;
import com.yangwei.www.view.pickerview.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author ____ Bye丶
 * @Date 2018/11/8
 * @Description PermissionActivity.
 */
public class PermissionActivity extends BaseActivity {

    @BindView(R.id.btn_camera)
    Button btnCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @OnClick(R.id.btn_camera)
    public void onViewClicked() {
        Calendar startCalendar = Calendar.getInstance(Locale.CHINA);
        Calendar endCalendar = Calendar.getInstance(Locale.CHINA);
        Calendar date = Calendar.getInstance(Locale.CHINA);
        date.add(Calendar.YEAR, 1);
        startCalendar.add(Calendar.MINUTE, 20);
        endCalendar.add(Calendar.MONTH, 1);

        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(PermissionActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                Log.i("pvTime", "onTimeSelect");

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setType(new boolean[]{true, true, true, true, true, false})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .setRangDate(startCalendar, endCalendar)
//                .setDate(date)
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
        pvTime.show();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
