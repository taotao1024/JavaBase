package com.lsy.oop.extend;

/**
 * 构造器
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/7
 */
public class Base {
    public double size;
    public double age;

    public Base(double size, double age) {
        this.size = size;
        this.age = age;
    }
}

class sub extends Base {
    public String name;

    public sub(double size, double age, String name) {
        super(size, age);
        this.name = name;
    }

    @Override
    public String toString() {
        return "sub{" +
                "size=" + size +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
