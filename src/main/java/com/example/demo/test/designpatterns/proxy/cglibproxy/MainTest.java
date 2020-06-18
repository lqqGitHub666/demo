package com.example.demo.test.designpatterns.proxy.cglibproxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/27 15:51
 * @注释：
 */
public class MainTest {

    public static void main(String[] args){
        CglibProxy cglibProxy = new CglibProxy();
        BuyCar buyHouseCglibProxy = (BuyCar) cglibProxy.getInstance(new BuyCar());
        buyHouseCglibProxy.buy();
    }
}
