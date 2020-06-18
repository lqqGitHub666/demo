package com.example.demo.test.designpatterns.proxy.cglibproxy;



import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 作者 lqq
 * @ClassName 类名 CglibProxy
 * @date 2019/8/27 15:37
 * @注释：
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("find car");
        Object result = methodProxy.invoke(object, args);
        System.out.println("handle procedures");
        return result;
    }

}
