package com.example.mzh.customviewstudy.bean;

/**
 * 作者：mazhihao
 * 邮箱：475451576@qq.com
 * 创建时间：2018/6/25
 * 描述：饼状图
 */
public class PieBean {
    private float value;//数值
    private float precentage;//百分比

    private int color;//颜色
    private float sweepAngle;//扫过的角度

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPrecentage() {
        return precentage;
    }

    public void setPrecentage(float precentage) {
        this.precentage = precentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }
}