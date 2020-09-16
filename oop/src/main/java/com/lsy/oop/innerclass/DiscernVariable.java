package com.lsy.oop.innerclass;

/**
 * 内部类、外部类变量名相同的情况下
 * <p>
 * this关键字 访问外部类实例变量的值
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/16
 */
public class DiscernVariable {
    private String prop = "外部类的实例对象";

    private class InClass {
        private String prop = "内部类的实例对象";

        public void info() {
            // 通过DiscernVariable.this.prop,访问外部类实例变量的值
            System.out.println("外部类实例变量的值: " + DiscernVariable.this.prop);
            // 通过this.prop,访问内部类实例变量的值
            System.out.println("内部类实例变量的值: " + this.prop);
        }
    }

    public void test() {
        InClass inClass = new InClass();
        inClass.info();
    }
}
