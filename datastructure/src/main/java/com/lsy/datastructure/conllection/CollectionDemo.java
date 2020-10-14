package com.lsy.datastructure.conllection;

import java.util.Collection;
import java.util.Iterator;

/**
 * 请跳转测试方法
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/08
 */
public class CollectionDemo {

    Collection collection = new Collection() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

    public void collectionTest() {
    }

    public void collectionEach() {
    }

    public void collectionRemoveIf() {
    }

}
