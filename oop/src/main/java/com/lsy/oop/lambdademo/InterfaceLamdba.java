package com.lsy.oop.lambdademo;

/**
 * @author YY
 */
@FunctionalInterface
public interface InterfaceLamdba {
    /**
     * 测试
     *
     * @param s s
     */
    void getString(String s);

    public static String setString(String s) {
        return "s";
    }
}
