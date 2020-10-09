package com.lsy.datastructure.map.hashmap;

import java.util.HashMap;

/**
 * HashMap的线程不安全主要体现在下面两个方面：
 * 1.在JDK1.7中，当并发执行扩容操作时会造成环形链和数据丢失的情况。
 * 2.在JDK1.8中，在并发执行put操作时会发生数据覆盖的情况。
 *
 * @author YY
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 1.7死循环   1.8元素覆盖 丢失
        new HashMap<>();
    }

/*    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
        // 判断数组是否存在 不存在则创建
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length; // 默认值为16
        // hashCode-1(减少碰撞概率) 与数组长度进行 与(位运算 相同则为1 不同则为0) 后四位
        // 通过hashCode与数组索引最大值进行位运算 确定数组的位置
        // 确定数组位置后  1、该位置为空 没有数据 2、该位置为链表 数据<8 3、该位置为红黑树 数据 >8
        if ((p = tab[i = (n - 1) & hash]) == null)
            // 数组为空 新建一个node 且下标为空 且直接插入数据
            tab[i] = newNode(hash, key, value, null);
        else {
            // 数组有值 发生碰撞
            HashMap.Node<K,V> e; K k;
            // 数组头结点校验 key是否一直
            // 判断hashCode         判断key是否相同
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
                // key相同 value赋值给e
                e = p;
            // 判断类型  是否满足红黑树还是链表
            else if (p instanceof HashMap.TreeNode)
                // 红黑树存放
                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 链表存放
                // 遍历链表
                for (int binCount = 0; ; ++binCount) {
                    // 尾插法
                    if ((e = p.next) == null) {
                        // 插入数据
                        p.next = newNode(hash, key, value, null);
                        // TREEIFY_THRESHOLD=8 判断链表是否转成红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            // 当数组容量小于64会对数组扩容  只有大于64的时候才会转换成红黑树
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 遍历链表检查 key是否一致 有可能hash一致但是key不同
                    // 判断hashCode        判断key是否相同
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key 的现有映射
                // 被覆盖的原值
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        // 数组容量
        ++modCount;
        // 扩容数组是否需要判断
        if (++size > threshold)
            resize();
        // 回调，允许LinkedHashMap的后操作
        afterNodeInsertion(evict);
        return null;
    }
    */
}
