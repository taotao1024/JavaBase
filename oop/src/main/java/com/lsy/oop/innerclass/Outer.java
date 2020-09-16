package com.lsy.oop.innerclass;

/**
 * 外部类访问内部类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/16
 */
public class Outer {

    private int outProp = 11;

    class Inner {
        private int inProp = 1;

        public void accessOuterProp() {
            System.out.println("内部类访问外部类: " + outProp);
        }
    }

    public void accessInnerProp() {
        // 外部类不能直接访问非静态内部类的实例变量,如果要访问需要创建内部类对象
        // System.out.println("外部类访问内部类: " +inProp);

        System.out.println("外部类访问内部类: " + new Inner().inProp);
    }
}
