package com.lsy.oop.finaldemo;

import java.util.Objects;

/**
 * 缓存不可变得类(模拟Integer)
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/9/14
 */
public class CacheImmutable {
    /**
     * 最大容量
     */
    private static int MAX_SIZE = 10;
    /**
     * 存储缓存的对象
     */
    private static CacheImmutable[] cache = new CacheImmutable[MAX_SIZE];
    /**
     * pos记录缓存实例在缓存中的位置，cache[pos-1]时最新的缓存的实例
     */
    private static int pos = 0;
    /**
     * 成员变量的属性
     */
    private final String name;

    public CacheImmutable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutable valueOf(String name) {
        // 遍历已经存在的对象
        for (int i = 0; i < MAX_SIZE; i++) {
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        // 缓存池已满
        if (pos == MAX_SIZE) {
            cache[0] = new CacheImmutable(name);
            pos = 1;
        } else {
            cache[pos++] = new CacheImmutable(name);
        }
        return cache[pos - 1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CacheImmutable that = (CacheImmutable) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
