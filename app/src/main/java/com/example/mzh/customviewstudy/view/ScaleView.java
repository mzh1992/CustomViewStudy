package com.example.mzh.customviewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：mazhihao
 * 邮箱：475451576@qq.com
 * 创建时间：2018/6/26
 * 描述：
 */
public class ScaleView extends View {
    private int mWidth, mHeight;
    private Paint mPaint;

    public ScaleView(Context context) {
        this(context, null);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        Rect rect = new Rect(-200, -200, 200, 200);
        for (int i=0;i<=30;i++) {
            canvas.scale(0.95f, 0.95f);
            canvas.drawRect(rect,mPaint);
        }
    }
}
