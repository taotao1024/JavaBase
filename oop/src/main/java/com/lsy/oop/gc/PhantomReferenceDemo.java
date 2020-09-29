package com.lsy.oop.gc;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/29
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws Exception {
        // 可达状态
        String s = new String("虚引用练习");
        // 创建一个引用队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        // 创建一个虚引用,让次虚引用引用到String
        PhantomReference phantomReference = new PhantomReference(s, referenceQueue);
        // 可恢复状态
        s = null;
        System.out.println(phantomReference.get());
        // 处罚GC
        System.gc();
        System.runFinalization();
        System.out.println(referenceQueue.poll() == phantomReference);

    }
}
