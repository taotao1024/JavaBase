package com.lsy.java8.Interfacedemo;


import java.nio.file.FileSystems;
import java.nio.file.Path;


/**
 * JDK8中为接口引入"静态方法"
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public interface InterfaceStaticMethod {
    /**
     * 测试接口的静态变量
     * <p>
     * public static final int A_INTI = 1;
     */
    String INTERFACE_INTI = "init Value";

    /**
     * 接口的默认方法1
     * <p>
     * default方法不能使用Static修饰
     * <p>
     * public  default void defaultMethod()
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
     * 获取A.value
     * <p/>
     * public
     */
    void getInit();

    /**
     * Java SE8 支持类方法 类方法必须使用static修饰
     * 类方法不能使用default修饰，且总是使用public修饰
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
