package com.lsy.newjdk.optional;

import java.util.Optional;

/**
 * @author TT
 */
public class TestOptional {

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
