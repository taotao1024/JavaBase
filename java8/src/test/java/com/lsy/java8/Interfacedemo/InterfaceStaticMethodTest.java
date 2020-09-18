package com.lsy.java8.Interfacedemo;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class InterfaceStaticMethodTest implements InterfaceStaticMethod {
    InterfaceStaticMethodTest instantiationTest;

    @Override
    public void defaultMethod() {
        System.out.println("接口的默认方法，可重写，也可以不重写。(重写后)");
    }

    @Override
    public void getInit() {
        System.out.println(InterfaceStaticMethod.INTERFACE_INTI);
    }

    @Before
    public void before() {
        instantiationTest = new InterfaceStaticMethodTest();
    }

    @Test
    public void testGetInit() {
        instantiationTest.getInit();
    }

    @Test
    public void testGetInitV2() {
        InterfaceStaticMethod i = () -> {
            System.out.println("函数式接口");
        };
        i.getInit();
    }

    @Test
    public void get() {
        Path path = InterfaceStaticMethod.get("jdk1.8.0_131", "jre", "bin");
        System.out.println(path);
    }

    @Test
    public void testDefaultMethod() {
        instantiationTest.defaultMethod();
    }

    @Test
    public void testDefaultMethodV1() {
        instantiationTest.defaultMethodV1();
    }

    @Test
    public void testDefaultSort() {
        ArrayList<String> array = new ArrayList<>();
        array.add("5");
        array.add("3");
        array.add("1");
        array.add("2");
        array.add("4");
        Collections.sort(array);
        System.out.println(array);
    }
}