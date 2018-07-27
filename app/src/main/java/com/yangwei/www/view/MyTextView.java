package com.yangwei.www.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.yangwei.www.utils.DeviceUtils;

/**
 * Created by yangwei on 2018/7/26.
 */

public class MyTextView extends View {
    private Context context;
    private Path path;

    public MyTextView(Context context) {
        super(context);
        this.context = context;
        initPath();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPath();
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initPath();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initPath();
    }

    private void initPath() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path = new Path();
        path.moveTo(0, 300);
        path.lineTo(300, 600);
        path.lineTo(600, 300);
        path.lineTo(900, 600);
//--------------------------------------
//        path.rLineTo(100, 100);
//        path.rLineTo(100, -100);
//        path.rLineTo(100, 100);
//--------------------------------------

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#000000"));
//        canvas.drawPath(path, paint);
        paint.setTextSize(DeviceUtils.dip2px(context, 15));
        canvas.drawTextOnPath("玩过自定义View的小伙伴都知道，在View的绘制过程中，有一个类叫做P" +
                "ath，Path可以帮助我们实现很多自定义形状的View，特别是配合xfermode ..", path, 0, 0, paint);
        canvas.drawText("玩过自定义View的小伙伴都知道，在View的绘制过程中，有一个类叫做P" +
                "ath，Path可以帮助我们实现很多自定义形状的View，特别是配合xfermode ..", 0, 800, paint);

        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(DeviceUtils.dip2px(context, 15));
        StaticLayout staticLayout = new StaticLayout("玩过自定义View的小伙伴都知道，在View的绘制" +
                "过程中，有一个类叫做Path，Path可以帮助我们实现很多自定义形状的View，特别是" +
                "配合xfermode ..", textPaint, 1080, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        staticLayout.draw(canvas);
    }
}
