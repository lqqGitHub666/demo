package com.example.demo.test.testinterface;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/19 15:34
 * @注释：
 */
public class MainTest{

    private static ThreadLocal<Connection> mainTestThreadLocal = new ThreadLocal<>();

    public void test(TestInterface testInterface){

        testInterface.add(1,2);
    }

    public void test1(){
    }

    public static void main(String[] args) {
        List<TestInterface> testInterfaces = new ArrayList<>();
        for (TestInterface testInterface : testInterfaces) {
            MainTest mainTest = new MainTest();
            mainTest.test(testInterface);
        }
    }
}
