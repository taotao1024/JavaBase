package com.lsy.oop.genericity;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GenericMethodTest {

    @Test
    public void formArrayToCollection() {
        // 下面代码中T代表Object类型
        Object[] oa = new Object[100];
        ArrayList<Object> co = new ArrayList<>();
        GenericMethod.formArrayToCollection(oa, co);
        // 下面代码中T代表了String类型
        String[] sa = new String[100];
        ArrayList<String> cs = new ArrayList<>();
        GenericMethod.formArrayToCollection(sa, cs);
        // 下面代码中T代表了Integer类型
        Integer[] oi = new Integer[100];
        ArrayList<Integer> ci = new ArrayList<>();
        GenericMethod.formArrayToCollection(oi, ci);
    }
}