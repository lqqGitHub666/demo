package com.example.demo.test.testclassloader;


/**
 * @author 作者 lqq
 * @ClassName 类名 ClassLoaderTest
 * @date 2019/9/4 11:36
 * @注释：
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {

            ClassLoaderDemo classLoader = new ClassLoaderDemo();
            Class driverClass = classLoader.loadClass("com.example.demo.test.testclassloader.ClassLoaderParent");
            ClassLoaderParent classLoaderParent = (ClassLoaderParent) driverClass.newInstance();
            classLoaderParent.say();
//            Class driverClass = Class.forName("com.example.demo.test.testclassloader.ClassLoaderParent",true,ClassLoaderTest.class.getClassLoader());
//            ClassLoaderParent classLoaderParent = (ClassLoaderParent) driverClass.newInstance();
//            System.out.println(classLoaderParent);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            //查看当前系统类路径中包含的路径条目
//            System.out.println(System.getProperty("java.class.path"));
//            //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
//            Class typeLoaded = Class.forName("com.example.demo.test.testclassloader.ClassLoaderParent");
//            //查看被加载的TestBean类型是被那个类加载器加载的
//            System.out.println(typeLoaded.getClassLoader());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}
