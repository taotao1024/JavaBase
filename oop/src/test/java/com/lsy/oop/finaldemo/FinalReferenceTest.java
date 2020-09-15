package com.lsy.oop.finaldemo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * FinalReference测试类
 */
public class FinalReferenceTest {

    @Test
    public void testFinalReference01() {
        final int[] iArr = {5, 11, 8, 19};
        System.out.println("修改前："+Arrays.toString(iArr));
        Arrays.sort(iArr);
        System.out.println("排序后："+Arrays.toString(iArr));
        iArr[3] = 2;
        System.out.println("修改后："+Arrays.toString(iArr));
        Arrays.sort(iArr);
        System.out.println("排序后："+Arrays.toString(iArr));
        // 对iArr重新赋值，语句报错。
        // iArr=null;
    }

    @Test
    public void testFinalReference02() {
        final Person person = new Person(23);
        System.out.println("修改前："+person.getAge());
        person.setAge(13);
        System.out.println("修改后："+person.getAge());
        // 对person重新赋值，语句报错。
        // person = null;
    }
}