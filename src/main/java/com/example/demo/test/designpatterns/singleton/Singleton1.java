package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton
 * @date 2019/8/26 15:42
 * @注释：饿汉式单例
 */
public class Singleton1 {

    // 指向自己实例的私有静态引用，主动创建
    private static Singleton1 singleton1 = new Singleton1();

    /**私有的构造方法*/
    private Singleton1(){}

    /**以自己实例为返回值的静态的公有方法，静态工厂方法*/
    public static Singleton1 getSingleton1(){
        return singleton1;
    }

    public void print(){
        System.out.println("i am Singleton1");
    }
}

class TestSingleton1 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton1();
        singleton1.print();
        System.out.println(singleton1);
        Singleton1 singleton11 = Singleton1.getSingleton1();
        System.out.println(singleton11);
    }
}


