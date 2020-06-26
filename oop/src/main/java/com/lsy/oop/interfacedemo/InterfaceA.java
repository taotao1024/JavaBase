package com.lsy.oop.interfacedemo;


import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author lsy
 */
public interface InterfaceA {
    /**
     * public static final int A_INTI = 1;
     */
    String A_INTI = "1";

    /**
     * 获取A.value
     * <p/>
     * public
     */
    void getA();

    /**
     * Java SE8 支持静态方法
     *
     * @param first first
     * @param more  其他
     * @return
     */
    public static Path get(String first, String... more) {
        return FileSystems.getDefault().getPath(first, more);
    }
}
