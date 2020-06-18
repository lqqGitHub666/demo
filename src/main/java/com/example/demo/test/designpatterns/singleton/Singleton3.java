package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton3
 * @date 2019/8/26 15:55
 * @注释：线程安全的懒汉式单例
 */
public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3(){}

    /**使用 synchronized 修饰，临界资源的同步互斥访问*/
    public static synchronized Singleton3 getSingleton3(){
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
