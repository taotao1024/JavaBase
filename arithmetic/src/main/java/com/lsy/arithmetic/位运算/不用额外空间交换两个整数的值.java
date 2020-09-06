package com.lsy.arithmetic.位运算;

/**
 * @author 19134
 */
public class 不用额外空间交换两个整数的值 {
    public static void main(String[] args) {
        int a = 200, b = 300;
        System.out.printf("交换前： a: %s,b: %s \n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("交换后： a: %s,b: %s \n", a, b);
    }

}
