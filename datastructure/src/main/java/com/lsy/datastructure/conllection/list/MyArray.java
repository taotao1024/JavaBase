package com.lsy.datastructure.conllection.list.array;

/**
 * 我的数组
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/29
 */
public class MyArray {

    private int size;
    private int[] array;

    public MyArray(int initSize) {
        this.array = new int[initSize];
        this.size = 0;
    }

    /**
     * 插入操作
     *
     * @param index   下标
     * @param element 插入的值
     */
    private void insert(int index, int element) throws Exception {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        //扩容
        if (this.size >= this.array.length) {
            resize();
        }
        //从右往左循环 后移动操作
        for (int i = this.size - 1; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }
        array[index] = element;
        this.size++;
    }

    /**
     * 删除数组
     *
     * @param index 下标
     */
    private void delete(int index) throws Exception {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("下标存在");
        }
        //移位操作
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        size--;
    }

    /**
     * 扩容操作
     */
    private void resize() {
        int[] newArray = new int[this.array.length * 2];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
        System.out.println("扩容成功,新数组大小为:" + this.array.length);
    }

    /**
     * 输出整个数组
     */
    private void output() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(4);
        myArray.insert(0, 10);
        myArray.insert(1, 11);
        myArray.insert(2, 12);
        myArray.insert(3, 13);
        //需要扩容
        myArray.insert(4, 14);
        myArray.delete(2);
        myArray.output();
    }
}
