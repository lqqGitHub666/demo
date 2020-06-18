package com.example.demo.test.testclassloader;
import java.net.URL;
import java.net.URLClassLoader;
/**
 * @author 作者 lqq
 * @ClassName 类名 ClassLoaderDemo
 * @date 2019/9/4 10:41
 * @注释：
 */
public class ClassLoaderDemo extends ClassLoader{


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name,false);
    }

//    @Override
//    protected Class<?> findClass(String name)throws ClassNotFoundException {
//        //假设此处只是到工程以外的特定目录Ｄ：/library下去加载类
//        //具体实现代码省略
//        return null;
//    }

    public static void main(String[] args)
    {
        System.out.println("BootstrapClassLoader 的加载路径: ");

        //String[] bootUrls = System.getProperty("sun.boot.class.path").split(";");

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls) {
            System.out.println(url);
        }
        System.out.println("----------------------------");

        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();

        System.out.println(extClassLoader);
        System.out.println("扩展类加载器 的加载路径: ");

        urls = extClassLoader.getURLs();
        for(URL url : urls) {
            System.out.println(url);
        }
        System.out.println("----------------------------");


        //取得应用(系统)类加载器
        URLClassLoader appClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();

        System.out.println(appClassLoader);
        System.out.println("应用(系统)类加载器 的加载路径: ");

        urls = appClassLoader.getURLs();
        for(URL url : urls) {
            System.out.println(url);
        }

        System.out.println("----------------------------");
    }

}