package com.lsy.oop.datatypedemo;


/**
 * 交换引用类型
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/6
 */
public class Demo02 {
    /**
     * 引用类型,值传递的是引用的地址
     * 基本类型,值传递的是变量的副本
     *
     * @param args string[]
     */
    public static void main(String[] args) {
        Person p1 = new Person("我是P1");
        Person p2 = new Person("我是P2");
        new Demo02().swapReference(p1, p2);
        System.out.println("主方法  交换后的P1: " + p1.getName());
        System.out.println("主方法  交换后的P2: " + p2.getName());
        // ---------------- 手动分隔符 ----------------
        int a = 11, b = 22;
        new Demo02().swapBase(a, b);
        System.out.println("主方法  交换后的a: " + a);
        System.out.println("主方法  交换后的b: " + b);
    }

    /**
     * 交换引用类型
     *
     * @param person1 p1
     * @param person2 p2
     */
    private void swapReference(Person person1, Person person2) {
        String temp = person1.getName();
        person1.setName(person2.getName());
        person2.setName(temp);
    }

    /**
     * 交换基本类型
     *
     * @param a a
     * @param b b
     */
    private void swapBase(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}

class Person {
    /**
     * 私有变量 姓名
     */
    private String name;

    /**
     * 构造方法
     *
     * @param name 姓名
     */
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
