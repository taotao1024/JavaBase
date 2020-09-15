package com.lsy.oop.abstractdemo;

/**
 * 抽象类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/15
 */
public abstract class BaseShape {
    {
        System.out.println("执行Shape的代码块");
    }

    /**
     * 成员变量 颜色
     */
    private String color;

    /**
     * 计算周长
     *
     * @return 周长
     */
    public abstract double calPerimeter();

    /**
     * 获取形状
     *
     * @return 形状
     */
    public abstract String getType();

    /**
     * 构造器不是用来实例化，而实用于被子类调用
     */
    public BaseShape() {
        System.out.println("执行Shape无参构造器");
    }

    /**
     * 构造器不是用来实例化，而实用于被子类调用
     */
    public BaseShape(String color) {
        System.out.println("执行Shape无参构造器");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
