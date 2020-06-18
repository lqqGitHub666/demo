package com.example.demo.test.designpatterns.factorymethod.simplefactory;

import com.example.demo.test.designpatterns.factorymethod.BMW;
import com.example.demo.test.designpatterns.factorymethod.Benzi;
import com.example.demo.test.designpatterns.factorymethod.Car;

/**
 * @author 作者 lqq
 * @ClassName 类名 CarFactory
 * @date 2019/8/26 17:08
 * @注释：
 */
public class SimpleFactory {
    public static Car createCar(String name){
        Car car = null;
        switch (name){
            case "benzi":
                car = new Benzi();
                break;
            case "BMW":
                car =  new BMW();
                break;
            default:
                car =  null;
                break;
        }
        return car;
    }
}
