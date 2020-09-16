package com.lsy.behaviormodeo.iterator.demo02.lang;

/**
 * 自定义可迭代的
 *
 * @param <E>
 */
public interface Iterable<E> {
    /**
     * 组合迭代器
     *
     * @return 迭代器
     */
    Iterator<E> iterator();

}
