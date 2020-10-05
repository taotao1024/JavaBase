package com.lsy.oop.genericity;

import java.util.List;

/**
 * 画矩形
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class Rectangle extends BaseShape {
    @Override
    public void draw(Canvas c) {
        System.out.println("把矩形画在画布" + c + "上");
    }

    public void addRectangle(List<? extends BaseShape> shapes) {
        // 引发编译错误 协变只进不出
        // shapes.add(new Rectangle());
    }
}
