package com.lsy.oop.interfacedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author lsy
 */
@RunWith(JUnit4.class)
public class A implements InterfaceA {
    @Override
    public void getA() {
        System.out.println(A_INTI);
    }


    @Test
    public void TestA() {
        System.out.println(InterfaceA.A_INTI);
        new A().getA();
        //InterfaceA.get("jdk1.8.0_131", "jre", "bin");
    }
}
