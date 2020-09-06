package com.lsy.thread.concurrentcollection;

import javax.lang.model.element.VariableElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞式集合
 *
 * @author YY
 */
public class ConcurrentHashMapDemo {
    /**
     * 初始化桶为16
     */
    ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<Integer, String>(4);
    /**
     * Stripped-down version of helper class used in previous version,
     * declared for the sake of serialization compatibility
     */
//                 分段
/*    static class Segment<K,V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;
        Segment(float lf) { this.loadFactor = lf; }
    }*/
}
