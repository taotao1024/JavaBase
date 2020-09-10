package com.lsy.constructmeode.decorator.demo00;

import org.junit.Test;

public class SsoInterceptorTest {

    @Test
    public void preHandle() {
        SsoInterceptor ssoInterceptor = new SsoInterceptor();
        String request = "1successhuahua";
        boolean success = ssoInterceptor.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}