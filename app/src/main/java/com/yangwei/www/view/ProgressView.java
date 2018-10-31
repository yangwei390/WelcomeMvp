package com.yangwei.www.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.yangwei.www.R;


/**
 * 加载Dialog View
 * Created by ____ Bye丶 on 2016/11/24.
 */

public class ProgressView extends View {
    private Context context;
    private Drawable bg;
    private int degrees;
    private int velocity = 5;
    private int width;

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        bg = ContextCompat.getDrawable(context, R.drawable.ic_loading);
        width = bg.getIntrinsicWidth();
        bg.setBounds(0, 0, width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBg(canvas);
        degrees = (degrees - velocity) % 360;
        invalidate();
    }

    private void drawBg(Canvas canvas) {
        canvas.save();
        canvas.rotate(-degrees, width / 2, width / 2);
        bg.draw(canvas);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        setMeasuredDimension(bg.getIntrinsicWidth(),
                bg.getIntrinsicHeight());
    }
}
