package com.example.demo.test.designpatterns.proxy.staticproxy;

import com.example.demo.test.designpatterns.proxy.dynamicproxy.BuyCar;
import com.example.demo.test.designpatterns.proxy.dynamicproxy.BuyCarImpl;

/**
 * @author 作者 lqq
 * @ClassName 类名 BuyCarProxy
 * @date 2019/8/27 11:25
 * @注释：
 */
public class BuyCarProxy implements BuyCar {

    private BuyCar buyCar;

    public BuyCarProxy(final BuyCar buyCar) {
        this.buyCar = buyCar;
    }

    @Override
    public void buy() {
        System.out.println("find car");
        buyCar.buy();
        System.out.println("handle procedures");
    }

    public static void main(String[] args) {
        BuyCar buyCar = new BuyCarImpl();
        buyCar.buy();
        BuyCarProxy buyCarProxy = new BuyCarProxy(buyCar);
        buyCarProxy.buy();
    }
}
