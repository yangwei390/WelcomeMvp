package com.yangwei.www.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yangwei.www.R;
import com.yangwei.www.utils.DeviceUtils;

/**
 * Created by yangwei on 2018/7/19.
 */

public class TestView extends View {
    private Context context;

    public TestView(Context context) {
        super(context);
        this.context = context;
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画个矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#009688"));
        canvas.drawRect(50, 50, 200, 200, paint);
        //画线
        paint.setColor(Color.parseColor("#FF34B3"));
        paint.setStrokeWidth(DeviceUtils.dip2px(context, 1));
        canvas.drawLine(50, 50, 200, 200, paint);
        canvas.drawLine(50, 200, 200, 50, paint);
        canvas.drawLine(50, 125, 200, 125, paint);
        canvas.drawLine(125, 50, 125, 200, paint);
        //画文字
        paint.setColor(Color.parseColor("#9AC0CD"));
        paint.setTextSize(DeviceUtils.dip2px(context, 20));
        canvas.drawText("窗前明月光", 250, 140, paint);
        //线性渐变圆
        //CLAMP
        Shader shaderClamp = new LinearGradient(175, 375, 175, 550,
                Color.parseColor("#EE00EE"), Color.parseColor("#1E90FF"), Shader.TileMode.CLAMP);
        paint.setShader(shaderClamp);
        canvas.drawCircle(175, 400, 150, paint);
        //MIRROR
        Shader shaderMirror = new LinearGradient(500, 375, 500, 550,
                Color.parseColor("#EE00EE"), Color.parseColor("#1E90FF"), Shader.TileMode.MIRROR);
        paint.setShader(shaderMirror);
        canvas.drawCircle(500, 400, 150, paint);
        //REPEAT
        Shader shaderRepeat = new LinearGradient(825, 375, 825, 550,
                Color.parseColor("#EE00EE"), Color.parseColor("#1E90FF"), Shader.TileMode.REPEAT);
        paint.setShader(shaderRepeat);
        canvas.drawCircle(825, 400, 150, paint);
        //辐射渐变圆
        Shader shader = new RadialGradient(175, 725, 50,
                Color.parseColor("#EE00EE"), Color.parseColor("#1E90FF"), Shader.TileMode.REPEAT);
        paint.setShader(shader);
        canvas.drawCircle(175, 725, 150, paint);
        //BitmapShader
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Shader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(bitmapShader);
//        canvas.drawCircle(500, 725, 1920, paint);
//        canvas.drawCircle(96, 96, 50, paint);
        //混合着色器
        Shader shader1 = new ComposeShader(shaderRepeat, bitmapShader, PorterDuff.Mode.SRC_OVER);
        paint.setShader(shader1);
        canvas.drawCircle(500, 725, 150, paint);
        //颜色过滤
        ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x003000);
        paint.setColorFilter(lightingColorFilter);
        canvas.drawCircle(825, 725, 150, paint);
        //Xfermode 混合

    }
}
