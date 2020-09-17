package com.lsy.java8.optional;

import java.util.Optional;

/**
 * OptionDemo
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/09/17
 */
public class OptionalDemo {

    public void testNoNull(String name) {
        Optional<String> optional = Optional.of(name);
    }

    public void testHasNull(String name) {
        Optional<String> optional = Optional.ofNullable(name);
        optional.orElse("init Name");
        System.out.println(optional.toString());
    }

    public String testHasNullV1(String name) {
        Optional<String> optional = Optional.ofNullable(name);
        return optional.orElse("init Name");
    }
}
