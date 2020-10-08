package com.lsy.oop.baseapi;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLOutput;

/**
 * Java程序的运行环境
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/06
 */
public class RuntimeApi {

    @Test
    public void testRT00() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("处理器数量 ： " + i);
    }

    @Test
    public void testRT01() {
        Long i = Runtime.getRuntime().freeMemory();
        System.out.println("空闲内存 ： " + i / 1024);
    }

    @Test
    public void testRT02() {
        Long i = Runtime.getRuntime().totalMemory();
        System.out.println("总内存 ： " + i / 1024);
    }

    @Test
    public void testRT03() {
        Long i = Runtime.getRuntime().maxMemory();
        System.out.println("可用内存 ： " + i / 1024);
    }

    @Test
    public void testRT04() {
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
