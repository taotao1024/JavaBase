package com.lsy.oop.gc;

import java.lang.ref.WeakReference;

/**
 * 弱引用练习
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/29
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        String s = new String("弱引用练习");
        // 创建一个弱引用对象
        WeakReference<String> stringWeakReference = new WeakReference<>(s);
        s = null;
        // 取出弱引用所引用的对象
        System.out.println(stringWeakReference.get());
        // 强制GC回收
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(stringWeakReference.get());
    }
}
