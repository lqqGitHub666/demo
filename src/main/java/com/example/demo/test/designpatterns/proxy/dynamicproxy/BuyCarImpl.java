package com.example.demo.test.designpatterns.proxy.dynamicproxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 BuyCarImpl
 * @date 2019/8/27 11:21
 * @注释：
 */
public class BuyCarImpl implements BuyCar {
    @Override
    public void buy() {
        System.out.println("buyCar and pay money");
    }
}
