package com.example.demo.test.testextends;

/**
 * @author 作者 lqq
 * @ClassName 类名 GrandFather
 * @date 2019/8/1 10:04
 * @注释：
 */
public class GrandFather implements People {
    @Override
    public void say() {
        System.out.println("hello world");
    }


    public void write(){
        System.out.println("write");
    }
}
