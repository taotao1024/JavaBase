package com.lsy.oop;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/6
 */
public class Demo1 {
    private static void swap(Person person1,Person person2){
        String temp=person1.getName();
       /* person1=person2;
        person2=temp;*/
       person1.setName(person2.getName());
       person2.setName(temp);
    }
    public static void main(String[] args) {
        Person p1 = new Person("我是P1");
        Person p2 = new Person("我是P2");
        //new Demo1().swap(p1,p2);
        swap(p1,p2);
        System.out.println("主方法  交换后的P1: "+p1.getName());
        System.out.println("主方法  交换后的P2: "+p2.getName());
    }


    private void changeInt(int oldInt){
        oldInt=10;
    }
}

class Person {
    private String name;

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
