package com.example.demo.test.designpatterns.singleton;

import java.util.UUID;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton6
 * @date 2019/8/26 16:01
 * @注释：线程安全的懒汉式单例DCL
 */
public class Singleton6 {

    /**使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例*/
    private static volatile Singleton6 singleton6;

    private Singleton6() {
    }

    public static Singleton6 getSingleton6() {
        // Double-Check idiom
        System.out.println(singleton6);
        if (singleton6 == null) {
            // 1
            synchronized (Singleton6.class) {
                /**只需在第一次创建实例时才同步*/
                // 2
                if (singleton6 == null) {
                    // 3
                    singleton6 = new Singleton6();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return singleton6;
    }

    public static void main(String[] args) {
//        for (int i = 0; i <20 ; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Singleton6.getSingleton6();
//                }
//            }).start();
//        }
        String s = UUID.randomUUID().toString();
        System.out.println(s.replaceAll("-",""));
    }
}
