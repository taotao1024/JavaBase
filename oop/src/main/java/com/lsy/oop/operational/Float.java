package com.lsy.oop.operational;

/**
 * @author TT
 */
public class Float {
    public static void main(String[] args) {
        byte a = 5;
        /*下面语句会出错，因为5的默认类型是int，a + 5 自动转换为int类型。
        把 int类型赋值给 byte类型会出错，需要强制转换 。*/
//        a = a + 5;
        byte b = 5;
//        +=是赋值运算符 只会出发自动提升，不会触发自动转换。
        b += 5;
    }

}
