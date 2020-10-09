package com.lsy.datastructure.conllection.list;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/6/4
 */
public class MyArrayList {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 为节点
     */
    private Node last;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 插入节点
     *
     * @param data
     * @param index
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        //参数校验
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空节点
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //头插
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //尾插
            last.next = insertNode;
            last = insertNode;
        } else {
            //中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表查找元素
     *
     * @param index 查找的未知
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index >= size || index == 0) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;

    }

}
