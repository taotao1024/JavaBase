package com.lsy.oop;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/6
 */
public class Demo01 {
    public static void main(String[] args) {
        Man man1 = new Man("原名称");
        System.out.println(man1.getName());
        new Demo01().changeMan(man1);
        System.out.println(man1.getName());

        int i=1;
        System.out.println("原来的值"+i);
        new Demo01().changeInt(i);
        System.out.println("改变后值"+i);
    }
    private void changeMan(Man oldMan){
        oldMan.setName("新名称");
    }

    private void changeInt(int oldInt){
        oldInt=10;
    }
}

class Man {
    private String name;

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
