package com.example.demo.test.teststatic;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestStatic
 * @date 2019/9/27 16:48
 * @注释：
 */
public class TestStatic {

    public static String test;

    static{
        System.out.println(test);
    }

    public static void sys(){
        System.out.println(test);
    }
}
