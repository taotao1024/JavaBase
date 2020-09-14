package com.lsy.oop.finaldemo;

/**
 * Final引用变量的修改
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/14
 */
public class FinalReference {

}

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}