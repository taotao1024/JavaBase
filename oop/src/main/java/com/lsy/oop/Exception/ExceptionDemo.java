package com.lsy.oop.Exception;

import sun.applet.Main;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 异常
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/09
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        // JDK7增强了try的语句功能，允许在try关键字后面跟一个()，显示的获取资源。
        // 但这些资源必须实现Closeable、AutoCloseable接口的close()方法。
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("ExceptionDemo.java"))){
            int i = 1 / 0;
        } catch (ClassCastException | NumberFormatException e) {
            System.out.println("类型转换异常或数字格式异常");
            // 捕获多异常时，变量隐士默认final修饰，无法从新赋值。
            //e=new IndexOutOfBoundsException("数组越界");
        } catch (Exception e) {
            // 返回异常的详细描述信息
            System.out.println(e.getMessage());
            // 将异常的堆栈信息，输出到标准错误输出 原始的异常信息
            e.printStackTrace();
            // 捕获单个异常时，变量可以被重新赋值。 给用户提示的异常信息
            e = new IndexOutOfBoundsException("数组越界");
            e.printStackTrace();
        } finally {
            // 一但在finally语句中使用return、throw，会导致try、catch语句中的return失效。
        }
    }
}
