package com.example.demo.test.designpatterns.factorymethod.abstractfactory;

import com.example.demo.test.designpatterns.factorymethod.BMW;
import com.example.demo.test.designpatterns.factorymethod.Car;

/**
 * @author 作者 lqq
 * @ClassName 类名 BMWFactory
 * @date 2019/8/26 17:21
 * @注释：
 */
public class BMWFactory extends Factory {
    @Override
    public Car createCar() {
        System.out.println("create a BMW");
        return new BMW();
    }
}
