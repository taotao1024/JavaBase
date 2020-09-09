package com.lsy.constructmeode.decoratorpattern.demo02;

import com.lsy.constructmeode.decoratorpattern.demo00.HandlerInterceptor;

/**
 * 抽象类 不理解
 */
public abstract class SsoDecorator implements HandlerInterceptor {
    /**
     * 模拟注入
     */
    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator() {
    }

    /**
     * 构造器注入
     *
     * @param handlerInterceptor 处理器拦截器
     */
    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    /**
     * 前置处理器
     *
     * @param request  请求
     * @param response 相应
     * @param handler  处理器
     * @return
     */
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
