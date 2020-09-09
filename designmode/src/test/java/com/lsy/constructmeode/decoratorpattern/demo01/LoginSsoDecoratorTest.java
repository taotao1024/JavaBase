package com.lsy.constructmeode.decoratorpattern.demo01;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginSsoDecoratorTest {

    @Test
    public void preHandle() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator();
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}