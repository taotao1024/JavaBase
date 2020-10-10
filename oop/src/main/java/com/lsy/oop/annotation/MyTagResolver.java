package com.lsy.oop.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * MyTag注解解析器
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/10
 */
public class MyTagResolver {
    public static void main(String[] args) throws NoSuchMethodException {
        Annotation[] array = CustomAnnotation.class.getAnnotations();
        for (Annotation a : array) {
            if (a instanceof MyTag)
                System.out.println("MyTag注解的Name变量 : " + ((MyTag) a).name());
        }
    }
}
