package com.lsy.oop.genericity;

import java.util.List;

/**
 * 绘制图形
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class Canvas {

    /**
     * 在画布上绘制图形
     *
     * @param shapes 形状
     */
    public void drawAll(List<? extends BaseShape> shapes) {
        shapes.forEach((shape) -> shape.draw(this));
    }
}
