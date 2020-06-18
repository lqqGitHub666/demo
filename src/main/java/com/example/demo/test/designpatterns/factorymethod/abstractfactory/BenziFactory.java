package com.example.demo.test.designpatterns.factorymethod.abstractfactory;

import com.example.demo.test.designpatterns.factorymethod.Benzi;
import com.example.demo.test.designpatterns.factorymethod.Car;

/**
 * @author 作者 lqq
 * @ClassName 类名 BenziFactory
 * @date 2019/8/26 17:20
 * @注释：
 */
public class BenziFactory extends Factory {
    @Override
    public Car createCar() {
        System.out.println("create a benzi");
        return new Benzi();
    }
}
