package com.lsy.oop.abstractdemo;

/**
 * 三角形
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/15
 */
public class Triangle extends BaseShape {
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.setSides(a,b,c);
    }

    public void setSides(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("三角形两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "三角形";
    }
}
