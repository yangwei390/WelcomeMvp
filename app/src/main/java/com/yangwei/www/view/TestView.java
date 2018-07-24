package com.yangwei.www.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

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
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

//        paint.setColor(ContextCompat.getColor(context, R.color.colorAccent));
        paint.setARGB(255, 0, 0, 0);

        canvas.drawCircle(320, 320, 300, paint);
    }
}
