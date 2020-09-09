package com.lsy.constructmeode.decoratorpattern.demo00;

/**
 * 自定义的处理器拦截器
 */
public interface HandlerInterceptor {
    /**
     * 前置处理器
     *
     * @param request  请求
     * @param response 相应
     * @param handler  处理器
     * @return Boolean
     */
    boolean preHandle(String request, String response, Object handler);

}
