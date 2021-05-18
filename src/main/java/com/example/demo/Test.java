package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2021/1/15 22:04
 * @注释：
 */
public class Test {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.save();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("lalala");
        System.out.println(test.atomicInteger);
    }

    public void save(){
        atomicInteger.getAndIncrement();
    }
}
