package com.lsy.java8.lambda;

import java.sql.SQLOutput;

/**
 * 局部变量访问
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/20
 */
public class LambdaDemo {

    /**
     * 堆变量
     */
    static int classNumber = 3200;

    public static void main(String[] args) {
        // 相当于 final int portNumber = 1337;
        /*
         *局部变量保存在栈上， 并且隐式表示它们仅限于其所在线程。
         * 如果允许捕获可改变的局部变量，就会引发造成线程 不安全的新的可能性.
         * （实例变量可以，因为它们保存在堆中，而堆 是在线程之间共享的）
         */
        int portNumber = 1337;
        Runnable r = () -> {
            classNumber = 3260;
            // Lambda可以没有限制的捕获实例变量和静态变量，但是局部变量必须显式声明为final或者实际上是final
            System.out.println(portNumber);
            System.out.println(classNumber);
        };
        // 下面代码编译不容过
        // portNumber=1334;
        r.run();
    }
}
