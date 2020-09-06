package com.lsy.arithmetic.其他;

public class Demo3 {

    public static void main(String[] args) {
        int[] block_list = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] ints = {};
        int result = func1(block_list);
        System.out.println(result);
    }

    public static int func1(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            //头
            if (i == 0) {
                if (list[i] - list[i + 1] > 0) {
                    System.out.println(list[i]);
                    list[i] = list[i] - 1;
                    result += 1;
                }
            }
            //尾
            else if (i == list.length) {
                if (list[i - 1] - list[i] < 0) {
                    System.out.println(list[i]);
                    list[i] = list[i] - 1;
                    result += 1;
                }
            }
            //中间
            else {
                /*if (list[i - 1] - list[i] > 0 && list[i + 1] - list[i] > 0) {
                    list[i] = list[i] - 1;
                    result += 1;
                }*/
            }
        }

        result = 6;
        return result;
    }
}
