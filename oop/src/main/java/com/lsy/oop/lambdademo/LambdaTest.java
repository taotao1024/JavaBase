package com.lsy.oop.lambdademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author lsy
 */
@RunWith(JUnit4.class)
public class LambdaTest implements InterfaceLamdba {

    @Override
    public void getString(String s) {
        System.out.println(s);
    }

    @Test
    public void TestLambda() {
        InterfaceLamdba s = (sa) -> {
            String result = "1";
            System.out.println(result);
        };

    }
}
