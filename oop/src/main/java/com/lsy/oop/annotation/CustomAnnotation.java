package com.lsy.oop.annotation;

import java.lang.annotation.Annotation;

/**
 * 自定义注解
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/10
 */
@MyTag
public class CustomAnnotation  {
    @MyTag(name = "testMethod")
    private void testMethod(){

    }
    @Override
    @MyTag
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    @MyTag
    public int hashCode() {
        return 0;
    }

    @Override
    @MyTag
    public String toString() {
        return null;
    }
}
