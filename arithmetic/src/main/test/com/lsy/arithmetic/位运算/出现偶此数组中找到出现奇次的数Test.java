package com.lsy.arithmetic.位运算;

import junit.framework.TestCase;
/**
 * @author 19134
 */
public class 出现偶此数组中找到出现奇次的数Test extends TestCase {
    出现偶此数组中找到出现奇次的数 test = new 出现偶此数组中找到出现奇次的数();

    public void testPrintOddTimesNum1() {
        int[] arr = {2, 2, 1, 2, 2, 4, 4, 3, 3, 6, 6};
        test.printOddTimesNum1(arr);
    }

    public void testPrintOddTimesNum2() {
        int[] arr = {2, 2, 1, 3, 3, 9};
        test.printOddTimesNum2(arr);
    }
}