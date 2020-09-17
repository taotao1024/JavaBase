package com.lsy.behaviormode.iterator.demo02.lang;

/**
 * 自定义迭代器
 * <p>
 * E - Element (在集合中使用，因为集合中存放的是元素)<p>
 * T - Type（Java 类）<p>
 * K - Key（键）<p>
 * V - Value（值）<p>
 * N - Number（数值类型）<p>
 * ？ -  表示不确定的java类型<p>
 *
 * @param <E> 泛型：元素
 */
public interface Iterator<E> {
    /**
     * 是否有下一个
     *
     * @return
     */
    boolean hasNext();

    /**
     * 下一个
     *
     * @return
     */
    E next();

}
