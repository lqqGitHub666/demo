package com.example.demo.test.testextends;

/**
 * @author 作者 lqq
 * @ClassName 类名 Son
 * @date 2019/8/1 10:04
 * @注释：
 */
public class Son extends Father {

    public void sayS() {
        say();
    }

//    @Override
//    public void say() {
//        super.say();
//    }

    public static void main(String[] args) {
        Son son = new Son();
        son.say();
        son.write();
    }
}
