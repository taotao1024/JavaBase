package com.lsy.oop.baseapi;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 输入输出API
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/06
 */
public class ScannerApi {
    public static void main(String[] args) {
        testScannerApi01();
    }

    public static void testScannerApi00() {
        Scanner scanner = new Scanner(System.in);
        // 将回车作为分隔符
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            System.out.println("键盘输入 ： " + scanner.next());
        }
    }

    public static void testScannerApi01() {
        Scanner scanner = null;
        try {
            System.out.println(System.getProperty("user.dir") + "oop\\src\\main\\java\\com\\lsy\\oop\\baseapi\\SystemApi.java");
            System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
            scanner = new Scanner(new File("D:\\Program Files\\IdeaProjects\\Git\\JavaBase\\oop\\src\\main\\java\\com\\lsy\\oop\\baseapi\\SystemApi.java"));
            //scanner = new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource("")+"com\\lsy\\oop\\baseapi\\SystemApi.class"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 将回车作为分隔符
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            System.out.println("文件输入 ： " + scanner.next());
        }
    }
}
