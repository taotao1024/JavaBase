package com.lsy.oop.finaldemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringJoinTest {

    @Test
    public void testStringJoin(){
        String s1="RX310 Y7000";
        String s2="RX310"+" Y7000";
        // true
        System.out.println(s1==s2);
        String str1="RX310";
        String str2="Y7000";
        String str3=str1+str2;
        // false
        System.out.println(s1==str3);

    }
}