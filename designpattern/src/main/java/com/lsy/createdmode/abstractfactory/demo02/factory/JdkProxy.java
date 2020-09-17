package com.lsy.createdmode.abstractfactory.demo02.factory;

import com.lsy.createdmode.abstractfactory.demo02.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author TT
 */
public class JdkProxy {

    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        // 代理对象
        InvocationHandler handler = new JdkInvocationHandler(cacheAdapter);
        // 类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 代理目标接口
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }

    static class JdkInvocationHandler implements InvocationHandler {

        private ICacheAdapter cacheAdapter;

        public JdkInvocationHandler(ICacheAdapter cacheAdapter) {
            this.cacheAdapter = cacheAdapter;
        }

        /**
         * @param proxy  代理对象
         * @param method 代理方法
         * @param args   代理方法参数
         * @return 代理对象执行结果
         * @throws Throwable 运行时异常
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
        }
    }
}
