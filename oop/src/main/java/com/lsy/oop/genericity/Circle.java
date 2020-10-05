package com.lsy.oop.genericity;

/**
 * 画圆
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class Circle extends BaseShape {
    @Override
    public void draw(Canvas c) {
        System.out.println("画画布" + c + "画一个圆");
    }
}
