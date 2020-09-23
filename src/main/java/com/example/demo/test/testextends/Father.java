package com.example.demo.test.testextends;

/**
 * @author 作者 lqq
 * @ClassName 类名 Father
 * @date 2019/8/1 10:03
 * @注释：
 */
public class Father extends GrandFather {

    @Override
    public void say () {
//        super.say();
        System.out.println("father say hello");

    }

    public void says(){
        super.say();
        say();
    }

    public static void main(String[] args) {
        Father father = new Father();
        father.says();
    }
}
