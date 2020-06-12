package com.lsy.datastructure.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/28
 */
@RunWith(JUnit4.class)
public class TestMyArray {
    /**
     * 数组长度
     */
    private int[] array;
    /**
     * 数组实际大小
     */
    private int size;

    @Test
    public void testArrayRead() {
        this.array = new int[]{1, 2, 13, 24, 12, 34, 12, 3, 41, 234};
        System.out.println(array[3]);
    }

    @Test
    public void testArrayUpdata() {
        this.array = new int[]{1, 2, 13, 24, 12, 34, 12, 3, 41, 234};
        System.out.println(array[3]);
        this.array[3] = 12;
        System.out.println(array[3]);
    }


}
