package com.lsy.createdmode.builder.demo01;

import org.junit.Test;

import java.math.BigDecimal;

public class DecorationPackageControllerTest01 {
    /**
     * 模拟注入
     */
    DecorationPackageController decoration = new DecorationPackageController();

    @Test
    public void testDecorationPackageController01() {
        // 豪华欧式
        System.out.println(decoration.getMatterList(new BigDecimal("132.52"), 1));
    }

    @Test
    public void testDecorationPackageController02() {
        // 轻奢田园
        System.out.println(decoration.getMatterList(new BigDecimal("98.25"), 2));
    }

    @Test
    public void testDecorationPackageController03() {
        // 现代简约
        System.out.println(decoration.getMatterList(new BigDecimal("85.43"), 3));
    }


}