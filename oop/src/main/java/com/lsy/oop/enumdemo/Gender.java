package com.lsy.oop.enumdemo;

/**
 * 枚举类型构造器、成员变量、方法
 * <p>
 * 抽象枚举类默认为final修饰
 * <p>
 * 抽象内聚类默然为abstract修饰
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/28
 */
public enum Gender implements GenderDesc {
    /**
     * 男
     */
    MALE("男"),
    /**
     * 女
     */
    FEMALE("女");

    /**
     * 定义一个final修饰的实例变量
     */
    private final String name;

    /**
     * 有参构造函数
     *
     * @param name 名字
     */
    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void info() {
        System.out.println("这是用于定义性别的枚举类");
    }}
