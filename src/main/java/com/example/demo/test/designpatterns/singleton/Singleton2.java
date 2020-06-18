package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton2
 * @date 2019/8/26 15:46
 * @注释：懒汉式单例
 */

public class Singleton2 {

    /**指向自己实例的私有静态引用*/
    private static Singleton2 singleton2;

    /**私有的构造方法*/
    private Singleton2(){}

    /**以自己实例为返回值的静态的公有方法，静态工厂方法*/
    public static Singleton2 getSingleton2(){
        // 被动创建，在真正需要使用时才去创建
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public void print(){
        System.out.println("i am Singleton2");
    }
}

class TestSingleton2{
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getSingleton2();
        singleton2.print();
        System.out.println(singleton2);
        Singleton2 singleton21 = Singleton2.getSingleton2();
        System.out.println(singleton21);
    }
}