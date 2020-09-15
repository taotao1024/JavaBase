package com.lsy.oop.extendsdemo;

/**
 * 重写
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/7
 */
public class Bird {
    public void fly() {
        System.out.println("我可以在天空自由的飞翔");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        System.out.println("我只能在地上自由的奔跑");
    }
}
