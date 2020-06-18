package com.example.demo.test.testabstract;

/**
 * @author 作者 lqq
 * @ClassName 类名 Cooker
 * @date 2019/8/30 16:08
 * @注释：
 */
public class Cooker extends Cook {

    @Override
    public int chaoCai(int a) {
        if (a == 0){
            return 0;
        }
        return 1;
    }

    @Override
    public int zhuFan(int b) {
        if (b==0){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Cook cook = new Cooker();
        System.out.println(cook.eat(1, 0));
    }
}
