package com.lsy.oop.baseapi;

import java.util.Objects;

/**
 * 对象工具API
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/06
 */
public class ObjectsApi {
    static ObjectsApi obj;

    public static void main(String[] args) {
        // 输出一个null空对象的字符串，不会引发空指针异常。
        System.out.println(Objects.toString(obj));
        // 输出一个null对象的HashCode值，不会引发空指针异常
        System.out.println(Objects.hashCode(obj));
        // 要求obj不能是null，否则引发异常。
        System.out.println(Objects.requireNonNull(obj, "obj参数不能是null！"));
    }
}
