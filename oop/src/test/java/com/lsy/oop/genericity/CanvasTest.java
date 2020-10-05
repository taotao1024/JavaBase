package com.lsy.oop.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CanvasTest {

    @Test
    public void drawAll() {
        /* ? extends BaseShape 表示BaseShape未知的子类，程序无法确认这个类型是什么 所以无法添加到集合中
          协变的泛型 只能调用泛型类型作为返回值类型的方法，而不能调用泛型类型作为参数的方法 --> 只出不进 */
        // List<? extends BaseShape> Circle = new ArrayList<>();
        List<BaseShape> Circle = new ArrayList<>();
        Circle.add(new Circle());
        Circle.add(new Rectangle());

        // 不能把List<Circle>当成List<BaseShape>使用，所以下面代码引起编译错误。
        // 需要设置通配符上限
        new Canvas().drawAll(Circle);
    }
}