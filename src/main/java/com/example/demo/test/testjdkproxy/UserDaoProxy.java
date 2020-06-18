package com.example.demo.test.testjdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 作者 lqq
 * @ClassName 类名 UserDaoProxy
 * @date 2019/12/19 16:57
 * @注释：
 */
public class UserDaoProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法");
        return 1;
    }
}
