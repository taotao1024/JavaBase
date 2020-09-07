package com.lsy.newjdk.lambdademo;

import org.junit.Test;

import java.util.function.IntFunction;

public class intFunctionTest {
    @Test
    public void testIntFunction() {
        IntFunction test = (s) -> {
            if (s >= 0) {
                System.out.println("处理内容 : " + s);
            } else {
                s = -1;
                System.out.println("处理失败 : " + s);
            }
            return s;
        };
        // 调用方法
        test.apply(11);
        test.apply(0);
        test.apply(-11);

    }
}
