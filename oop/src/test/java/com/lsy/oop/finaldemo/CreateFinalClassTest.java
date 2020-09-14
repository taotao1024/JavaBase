package com.lsy.oop.finaldemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateFinalClassTest {

    @Test
    public void testCreateFinalClass(){
        Name name = new Name("吴", "鸣");
        CreateFinalClass finalClass = new CreateFinalClass(name);
        System.out.println(finalClass.getName().getFirstName());
        name.setFirstName("佑");
        System.out.println(finalClass.getName().getFirstName());
    }
}