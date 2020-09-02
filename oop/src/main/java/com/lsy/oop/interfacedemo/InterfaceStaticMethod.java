package com.lsy.oop.interfacedemo;


import java.nio.file.FileSystems;
import java.nio.file.Path;


/**
 * @author TT
 */
public interface InterfaceStaticMethod {

    /**
     * 接口的默认方法1
     */
    default void defaultMethod() {
        System.out.println("我是接口的默认方法(重写前)");
    }

    /**
     * 接口的默认方法2
     */
    default void defaultMethodV1() {
        System.out.println("没重写的默认方法(重写前)");
    }

    /**
     * 测试接口的静态变量
     * <p>
     * public static final int A_INTI = 1;
     */
    String INTERFACE_INTI = "init Value";

    /**
     * 获取A.value
     * <p/>
     * public
     */
    void getInit();

    /**
     * Java SE8 支持静态方法
     * <p>
     * 接口的静态方法依旧属于接口，只能由接口自己调用。
     *
     * @param first first
     * @param more  其他
     * @return
     */
    static Path get(String first, String... more) {
        return FileSystems.getDefault().getPath(first, more);
    }
}
