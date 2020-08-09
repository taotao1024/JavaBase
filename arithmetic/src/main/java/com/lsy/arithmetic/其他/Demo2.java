package com.lsy.arithmetic.其他;

public class Demo2 {

    public static void main(String[] args) {
        int[] block_list={1,2,3,100};
        int[] ints = {};
        int result=func1(block_list,ints );
        System.out.println(result);
    }

    public static int func1(int[] block_list, int[] unblock_list) {
        int val = 60;
        for (int i = 1; i < block_list.length; i++) {
            if (block_list[i] - block_list[i - 1] < 60) {
                val = val + block_list[i] - block_list[i - 1];
            } else {
                val = val + 60;
            }
        }
        return val;
    }
}
