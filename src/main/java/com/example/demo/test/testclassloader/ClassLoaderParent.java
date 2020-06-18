package com.example.demo.test.testclassloader;

/**
 * @author 作者 lqq
 * @ClassName 类名 ClassLoaderParent
 * @date 2019/9/4 10:53
 * @注释：
 */
public class ClassLoaderParent {
//    public static void main(String[] args) {
//        try {
//            System.out.println(ClassLoader.getSystemClassLoader());
//            System.out.println(ClassLoader.getSystemClassLoader().getParent());
//            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public ClassLoaderParent(){
        System.out.println("对象被 new 了");
    }

    private static ClassLoaderParent classLoaderParent = new ClassLoaderParent();
    static {
        System.out.println("invoke clinit ClassLoaderParent is init");
    }

    public void say(){
        System.out.println("say hello classLoader");
    }

}
