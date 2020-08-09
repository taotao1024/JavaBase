package com.lsy.arithmetic.位运算;
/**
 * @author 19134
 */
public class 整数的二进制数表达中有多少个1 {
    public int count1(int n) {
        int res = 0;
        // 100 = 1100100B
        //  50 = 110010B
        //  25 = 11001B
        //  12 = 1100B
        //  6  = 110B
        //  3  = 11B
        //  1  = 1B
        //  0  = 0B
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int count2(int n) {
        int res = 0;
        //    n   = 100 =1100100B
        //   n-1  =  99 =1100011B
        // n&(n-1)=  96 =1100000B

        // 100 = 1100100B
        //  96 = 1100000B
        //  64 = 1000000B
        //  0  = 0000000B
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public int count3(int n) {
        int res = 0;
        while (n != 0) {
            // n & (~n + 1) 得到右侧最右侧的1
            n -= n & (~n + 1);
            res++;
        }
        return res;
    }

    /**
     * 平行算法
     *
     * @param n
     * @return
     */
    public int count4(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }


}
