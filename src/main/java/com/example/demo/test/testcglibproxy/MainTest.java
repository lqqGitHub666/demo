package com.example.demo.test.testcglibproxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/2 10:37
 * @注释：
 */
public class MainTest {

    public static void main(String[] args) {
        Star ldh = new LiuDeHua();

        StarProxy proxy = new StarProxy();

        proxy.setTarget(ldh);

        Object obj = proxy.CreatProxyedObj();

        Star star = (Star)obj;

        star.dance("");
        star.sing("");
    }
}
