package com.example.demo.test.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 作者 lqq
 * @ClassName 类名 DemoClinit
 * @date 2019/9/3 14:12
 * @注释：
 */
public class DemoClinit {

    public void say(){
        System.out.println("hello world");
    }

    static class Hello{

        private Hello(){
            System.out.println("new hello...");
        }

        static {
            System.out.println(Thread.currentThread().getName() + "init ...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        int i= 0;
        while (i<20){
            i++;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"start...");
                    Hello hello = new Hello();
                    System.out.println(Thread.currentThread().getName()+"end...");
                }
            });
        }
    }
}
