package com.example.demo.test.designpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 DynamicProxyHandler
 * @date 2019/8/27 11:33
 * @注释：
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("find car");
        Object result = method.invoke(object,args);
        System.out.println("handle procedures");
        return result;
    }

    public static void main(String[] args) {
        BuyCar buyCar = new BuyCarImpl();
        BuyCar proxyInstance = (BuyCar) Proxy.newProxyInstance(BuyCar.class.getClassLoader(), new
                Class[]{BuyCar.class}, new DynamicProxyHandler(buyCar));
        proxyInstance.buy();
    }
}
