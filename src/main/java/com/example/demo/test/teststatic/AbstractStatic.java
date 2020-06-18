package com.example.demo.test.teststatic;

/**
 * @author 作者 lqq
 * @ClassName 类名 AbstractStaticImpl
 * @date 2020/5/14 10:16
 * @注释：
 */
public class AbstractStatic implements TestAbstractStatic {

    private static final String bb = "bb";
    static {
        System.out.println(aa);
    }

    public void test(){

    }
}
