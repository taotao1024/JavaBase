package com.lsy.oop.baseapi;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * 系统API
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/05
 */
public class SystemApi {

    @Test
    public void testSystemApi00() {
        // 获取指定环境变量
        System.out.println("JAVA_HOME : " + System.getenv("JAVA_HOME"));
    }

    @Test
    public void testSystemApi01() {
        // 获取系统所有环境变量
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " --> " + env.get(name));
        }
    }

    /**
     * 加载动态链接库和加载文件主要用于native方法有用，对于一些特殊功能，Java无法实现的，可以必须借助C语言来实现。
     */
    @Test
    public void testSystemApi02() {
        // 用于加载动态链接库文件
        System.loadLibrary("");
    }

    @Test
    public void testSystemApi03() {
        // 获取指定属性
        System.out.println(System.getProperty("os.name"));
    }

    @Test
    public void testSystemApi04() {
        // 获取所有的系统属性
        Properties properties = System.getProperties();
        properties.forEach((String, P) ->
                System.out.println(String + " --> " + properties.getProperty(String.toString()))
        );
    }

    @Test
    public void testHashCode() {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        //String重写了HashCode方法-->改为根据字符串列计算HashCode值，因为s1和s2的字符串列相同，所以HashCode值相同
        System.out.println(s1.hashCode() + "-----" + s2.hashCode());
        // s1和s2是不同的字符串对象，所以他们的identityHashCode值不相同
        System.out.println(System.identityHashCode(s1)+ "-----" +System.identityHashCode(s2));
        String s3="Java";
        String s4="Java";
        // s1和s2是相同的字符串对象，所以他们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3)+ "-----" +System.identityHashCode(s4));
    }
}
