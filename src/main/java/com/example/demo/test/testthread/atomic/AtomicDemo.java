package com.example.demo.test.testthread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 作者 lqq
 * @ClassName 类名 AtomicDemo
 * @date 2019/10/16 16:59
 * @注释：
 */
public class AtomicDemo {

    private AtomicInteger value = new AtomicInteger(1);

//    private int value;

    public int getNext(){
        return value.getAndIncrement();
//        return value++;
    }

    public static void main(String[] args) {

        AtomicDemo atomicDemo = new AtomicDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicDemo.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicDemo.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicDemo.getNext());
                }
            }
        }).start();
    }
}
