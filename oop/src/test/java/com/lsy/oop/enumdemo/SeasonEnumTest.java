package com.lsy.oop.enumdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonEnumTest {

    @Test
    public void testSeasonEnum() {
        for (SeasonEnum s : SeasonEnum.values()) {
            // 默认执行toString方法
            System.out.println(s);
        }
    }

    static void Judge(SeasonEnum s) {
        switch (s) {
            case SPRING:
                System.out.println("春天来了");
                break;
            case SUMMER:
                System.out.println("夏天来了");
                break;
            case FALL:
                System.out.println("秋天来了");
                break;
            case WINTER:
                System.out.println("冬天来了");
                break;
        }
    }

    @Test
    public void testJudge() {
        this.Judge(SeasonEnum.SPRING);
        this.Judge(SeasonEnum.SUMMER);
        this.Judge(SeasonEnum.FALL);
        this.Judge(SeasonEnum.WINTER);
    }

    @Test
    public void testEnum() {
        // compareTo()方法用于指定枚举类对象比较的顺序
        System.out.println(SeasonEnum.FALL.compareTo(SeasonEnum.SPRING));
        System.out.println(SeasonEnum.SPRING.compareTo(SeasonEnum.FALL));
        // name()方法返回枚举类实例的名称
        System.out.println(SeasonEnum.FALL.name());
        // toString()方法返回枚举实例的名称
        System.out.println(SeasonEnum.FALL.toString());
        // ordinal()返回枚举类中的索引值
        System.out.println(SeasonEnum.FALL.ordinal());
        // 返回指定枚举类中指定名称的枚举值
        System.out.println(SeasonEnum.valueOf(SeasonEnum.class, "SPRING"));
    }
}