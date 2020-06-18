package com.example.demo.test.testcglibproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 StarProxy
 * @date 2019/8/1 17:57
 * @注释：
 */
public class StarProxy implements InvocationHandler
{
    /**目标类，也就是被代理对象*/
    private Object target;

    public void setTarget(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        // 这里可以做增强
        System.out.println("买票");

        Object result = method.invoke(target, args);

        return result;
    }

    /**生成代理类*/
    public Object CreatProxyedObj()
    {
        System.out.println(target.getClass().getClassLoader());
        System.out.println("-----------------------");
        System.out.println(target.getClass());
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}


