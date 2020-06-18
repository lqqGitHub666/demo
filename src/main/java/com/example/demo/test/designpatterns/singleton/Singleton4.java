package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton4
 * @date 2019/8/26 15:57
 * @注释：线程安全的懒汉式单例
 */
public class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4(){}


    public static Singleton4 getSingleton4(){
        /**使用 synchronized 块，临界资源的同步互斥访问*/
        synchronized(Singleton4.class){
            if (singleton4 == null) {
                singleton4 = new Singleton4();
            }
        }
        return singleton4;
    }
}
