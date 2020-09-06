package com.lsy.thread.singleton;

/**
 * 枚举
 * <p>
 * 优势：线程安全 唯一性 性能好
 * 劣势：无法保证懒加载
 * <p>
 *
 * @author YY
 */
public enum EnumSingleton {
    /**
     * 返回常量实例
     */
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}

