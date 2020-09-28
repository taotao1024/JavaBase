package com.lsy.oop.enumdemo;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class GenderTest {
    @Test
    public void testGender() {
        Gender male = Gender.valueOf(Gender.class, "MALE");
        System.out.println(male + "代表 :" + male.getName());
    }

    @Test
    public void testGenderDesc() {
       Gender.FEMALE.info();
    }

    @Test
    public void testEnumOrObject() {
        System.out.println(Gender.class instanceof Object);
        System.out.println(Gender.FEMALE instanceof Object);
        System.out.println(Gender.FEMALE instanceof Enum);
    }

}