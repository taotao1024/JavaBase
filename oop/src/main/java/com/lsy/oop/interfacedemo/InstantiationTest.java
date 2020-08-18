package com.lsy.oop.interfacedemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Path;


/**
 * @author TT
 */
@RunWith(JUnit4.class)
public class InstantiationTest implements InterfaceStaticMethod {
    InstantiationTest instantiationTest;

    @Override
    public void defaultMethod() {
        System.out.println("接口的默认方法，可重写，也可以不重写。(重写后)");
    }

    @Override
    public void getInit() {
        System.out.println(InterfaceStaticMethod.Interface_INTI);
    }

    @Before
    public void before() {
        instantiationTest = new InstantiationTest();
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
}
