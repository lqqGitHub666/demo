package com.example.demo.test.testjdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/12/19 16:59
 * @注释：
 */
public class MainTest {

    public static void main(String[] args) {
        UserDaoProxy userDaoProxy = new UserDaoProxy();
        UserDao userDao = (UserDao) Proxy.newProxyInstance(MainTest.class.getClassLoader(),new Class[]{UserDao.class},userDaoProxy);
        System.out.println(userDao.test());
    }

}
