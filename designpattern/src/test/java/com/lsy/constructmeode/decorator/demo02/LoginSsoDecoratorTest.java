package com.lsy.constructmeode.decorator.demo02;

import com.lsy.constructmeode.decorator.demo00.SsoInterceptor;
import org.junit.Test;

public class LoginSsoDecoratorTest {

    @Test
    public void preHandle() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}