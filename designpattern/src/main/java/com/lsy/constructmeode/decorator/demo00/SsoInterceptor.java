package com.lsy.constructmeode.decorator.demo00;

/**
 * SSO拦截器 校验Cookie
 */
public class SsoInterceptor implements HandlerInterceptor {

    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
