package com.example.demo.test.testabstract;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/28 10:17
 * @注释：
 */
public class MainTest {

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.testLambda((e) -> {
            System.out.println(e);
        });
        TestAbstract testAbstract = new TestAbstract("hehe") {
            @Override
            public void test(String content) {
                System.out.println(getContent());
            }
        };
        testAbstract.test("haha");
    }
}
