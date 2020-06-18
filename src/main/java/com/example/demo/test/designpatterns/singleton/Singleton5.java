package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 Singleton5
 * @date 2019/8/26 15:59
 * @注释：线程安全的懒汉式单例
 */
public class Singleton5 {

    private static int i=0;

    static {
        System.out.println("heihei");
    }

    /**私有内部类，按需加载，用时加载，也就是延迟加载*/
    private static class Holder {
        private static Singleton5 singleton5 = new Singleton5();
        static {
            System.out.println("haha");
        }
    }

    private Singleton5() {

    }

    public static Singleton5 getSingleton5() {
        return Holder.singleton5;
    }

    public static void main(String[] args) {
        System.out.println(Singleton5.i);
        System.out.println(Singleton5.getSingleton5());
    }
}
