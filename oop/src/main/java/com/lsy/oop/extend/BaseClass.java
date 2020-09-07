package com.lsy.oop.extend;

/**
 * super
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/7
 */
public class BaseClass {
    public int a = 1;
}

class SubClass extends BaseClass {
    public int a = 10;

    public void accessOwner() {
        System.out.println(a);
    }

    public void accessSuper() {
        System.out.println(super.a);
    }
}
