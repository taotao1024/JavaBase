package com.lsy.oop.genericity;

import java.util.Collection;
import java.util.HashMap;

/**
 * 泛型方法
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/29
 */
public class GenericMethod {
    /**
     * 泛型方法
     *
     * @param t   泛型数组
     * @param c   Collection对象
     * @param <T> 代指任意类型对象
     */
    static <T> void formArrayToCollection(T[] t, Collection<T> c) {
        for (T o : t) {
            c.add(o);
        }
    }

    static <K, V> HashMap<K, V> getHashMap() {
        return new HashMap<K, V>();
    }
}
