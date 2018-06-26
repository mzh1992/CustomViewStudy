package com.example.mzh.customviewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mzh.customviewstudy.bean.PieBean;

import java.util.List;

/**
 * 作者：mazhihao
 * 邮箱：475451576@qq.com
 * 创建时间：2018/6/25
 * 描述：
 */
public class PieView extends View {
    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private List<PieBean> pieBeanList;//数据

    private int startAngel = 0;//开始的角度

    private int mWidth, mHeight;
    private Paint mPaint;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void setPieBeanList(List<PieBean> pieBeanList) {
        this.pieBeanList = pieBeanList;
        initData(pieBeanList);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    /*
     * 设置开始的角度
     */
    public void setStartAngel(int startAngel) {
        this.startAngel = startAngel;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float currentAngle = startAngel;
        canvas.translate(mWidth / 2, mHeight / 2);
        float radius = Math.min(mWidth, mHeight) / 2;
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        for (int i = 0; i < pieBeanList.size(); i++) {
            mPaint.setColor(pieBeanList.get(i).getColor());
            canvas.drawArc(rectF, currentAngle, pieBeanList.get(i).getSweepAngle(), true, mPaint);
            currentAngle += pieBeanList.get(i).getSweepAngle();
        }
    }

    public void initData(List<PieBean> pieBeanList) {
        if (pieBeanList == null || pieBeanList.size() == 0) {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < pieBeanList.size(); i++) {
            sumValue = sumValue + pieBeanList.get(i).getValue();
            int j = i % mColors.length;       //设置颜色
            pieBeanList.get(i).setColor(mColors[j]);
        }

        for (int i = 0; i < pieBeanList.size(); i++) {
            PieBean pieBean = pieBeanList.get(i);
            float precentage = pieBean.getValue() / sumValue;
            pieBean.setPrecentage(precentage);
            pieBean.setSweepAngle(precentage * 360);
        }
    }
}