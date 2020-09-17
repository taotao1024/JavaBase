package com.lsy.behaviormode.iterator.demo02.lang;

/**
 * 自定义集合
 *
 * @param <E> element
 * @param <L> link
 */
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L l);

    boolean removeLink(String key);

    Iterator<E> iterator();

}
