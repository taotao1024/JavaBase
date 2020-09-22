package com.lsy.oop.innerclass;

/**
 * 无法访问非静态成员(In类)
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/21
 */
public class StaticTest {
    private class In {
    }

    public static void main(String[] args) {
        // 无法访问非静态成员
        // new In();
    }
}
