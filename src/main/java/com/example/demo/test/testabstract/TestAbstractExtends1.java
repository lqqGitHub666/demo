package com.example.demo.test.testabstract;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestAbstractExtends1
 * @date 2019/11/5 14:23
 * @注释：
 */
public class TestAbstractExtends1 extends TestAbstract {

    public TestAbstractExtends1(String content) {
        super(content);
    }

    @Override
    public void test(String content) {
        System.out.println("TestAbstractExtends1");
    }

    Map map = new HashMap();
}
