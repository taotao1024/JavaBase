package com.lsy.oop.abstractdemo;

/**
 * 圆
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/15
 */
public class Circle extends BaseShape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    public String getType() {
        return super.getColor()+"⚪";
    }
}
