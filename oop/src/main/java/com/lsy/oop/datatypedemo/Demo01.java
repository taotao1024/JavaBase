package com.lsy.oop.datatypedemo;

/**
 * 修改引用类型
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/6
 */
public class Demo01 {
    /**
     * 引用类型,值传递的是引用的地址
     * 基本类型,值传递的是变量的副本
     *
     * @param args string[]
     */
    public static void main(String[] args) {
        Man man1 = new Man("原名称");
        System.out.println("原来的值 " + man1.getName());
        new Demo01().changeMan(man1);
        System.out.println("原来的值 " + man1.getName());
        // ---------------- 手动分隔符 ----------------
        int i = 1;
        System.out.println("原来的值 " + i);
        new Demo01().changeInt(i);
        System.out.println("改变后值 " + i);
    }

    /**
     * 改变Man
     *
     * @param oldMan manValue
     */
    private void changeMan(Man oldMan) {
        // 引用类型的私有变量 只能通过封装的方法改变
        oldMan.setName("新名称");
    }

    /**
     * 改变Int
     *
     * @param oldInt intValue
     */
    private void changeInt(int oldInt) {
        oldInt = 10;
    }
}

/**
 * 互相独立的普通的类
 */
class Man {
    /**
     * 私有变量 姓名
     */
    private String name;

    /**
     * 有参构造方法
     *
     * @param name 姓名
     */
    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
