package com.example.mydemos.animation;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;

public class ShapeHolder {
    private float x = 0,y = 0;
    //形状
    private ShapeDrawable shape;
    private int color;
    //渐变
    private RadialGradient gradient;
    private Paint paint;
    private float alpha = 1f;

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ShapeDrawable getShape() {
        return shape;
    }

    public void setShape(ShapeDrawable shape) {
        this.shape = shape;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public RadialGradient getGradient() {
        return gradient;
    }

    public void setGradient(RadialGradient gradient) {
        this.gradient = gradient;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public ShapeHolder(ShapeDrawable shape) {
        this.shape = shape;
    }
    public float getWidth(){
        return shape.getShape().getWidth();
    }
    public float getHeigth(){
        return shape.getShape().getHeight();
    }
    public void setHeight(){
    }
    public void setWidth(){
    }
}
