package com.lsy.arithmetic.位运算;

/**
 * @author 19134
 */
public class 不做比较判断两个数大小 {

    /**
     * 如果n=1，返回0
     * <p>
     * 如果n=0，返回1
     *
     * @param n 1|0
     * @return 0|1
     */
    public int flip(int n) {
        return n ^ 1;
    }

    /**
     * 返回整数的符号位
     * <p>
     * 整数和0返回1
     * <p>
     * 负数返回0
     *
     * @param n 整数
     * @return 0|1
     */
    public int sign(int n) {
        // >> 右移获得符号位
        return flip((n >> 31) & 1);
    }

    /**
     * 无法处理a-b溢出问题
     *
     * @param a 整数
     * @param b 整数
     * @return max
     */
    public int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    /**
     * 解决a-b的溢出问题
     *
     * @param a 整数
     * @param b 整数
     * @return max
     */
    public int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
