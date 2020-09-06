package com.lsy.arithmetic.位运算;
/**
 * @author 19134
 */
public class 出现偶此数组中找到出现奇次的数 {
    /**
     * 一个奇数
     *
     * @param arr 数组
     */
    public void printOddTimesNum1(int[] arr) {
        int res = 0;
        for (int a : arr) {
            res ^= a;
        }
        System.out.printf("奇数为: %s \n",res);
    }

    /**
     * 两个奇数
     *
     * @param arr 数组
     */
    public void printOddTimesNum2(int[] arr) {
        int eO = 0, eOhasOne = 0;
        for (int a : arr) {
            eO ^= a;
            //  1  = 0001B
            //  9  = 1001B
            // 1^9 = 1000B =8
            // 因为有两个奇次数，所以最后的 eO=A^B && eO!=0；
        }
        // n & (~n + 1) 得到右侧最右侧的1
        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                // 9 = 1001B
                // 8 = 1000B
                //8&9= 1000B=8
                //0^9= 1001B=9
                //8^9= 0001B=1
                eOhasOne ^= cur;
            }
        }
        System.out.printf("第一个数: %s 第二个数: %s", (eO ^ eOhasOne), eOhasOne);
    }

    public static void main(String[] args) {
        System.out.println(8 ^ 9);
        System.out.println(8 ^ 1);
    }
}
