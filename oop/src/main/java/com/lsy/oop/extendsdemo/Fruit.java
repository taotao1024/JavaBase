package com.lsy.oop.extendsdemo;

/**
 * 继承
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/7
 */
public class Fruit {
    public double weight;

    public void info() {
        System.out.println("我是水果,重" + weight + "g");
    }
}

class Apple extends Fruit {

}