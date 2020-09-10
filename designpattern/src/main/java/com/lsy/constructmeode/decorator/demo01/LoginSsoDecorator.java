package com.lsy.constructmeode.decorator.demo01;

import com.lsy.constructmeode.decorator.demo00.SsoInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扩展SsoInterceptor
 */
public class LoginSsoDecorator extends SsoInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {

        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        boolean success = ticket.equals("success");
        if (!success) return false;
        // 新增的扩展的逻辑
        String userId = request.substring(9);
        String method = authMap.get(userId);

        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }

}
