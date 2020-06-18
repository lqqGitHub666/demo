package com.example.demo.test.designpatterns.factorymethod.abstractfactory;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/26 17:23
 * @注释：
 */
public class MainTest {
    public static void main(String[] args) {
        new BenziFactory().createCar().getName();
    }
}
