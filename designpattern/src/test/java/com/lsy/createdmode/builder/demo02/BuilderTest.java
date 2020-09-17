package com.lsy.createdmode.builder.demo02;

import org.junit.Test;

public class BuilderTest {
    /**
     * 模拟注入
     */
    Builder builder = new Builder();

    @Test
    public void levelOne() {
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());
    }

    @Test
    public void levelTwo() {
        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());
    }

    @Test
    public void levelThree() {
        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}