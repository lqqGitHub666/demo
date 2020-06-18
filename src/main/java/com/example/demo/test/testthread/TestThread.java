package com.example.demo.test.testthread;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestThread
 * @date 2020/1/8 16:14
 * @注释：
 */
public class TestThread {
    public static void main(String[] args) {

//        Thread thread = new Thread();
//        Executor executor = new ScheduledThreadPoolExecutor(1);

//        for (int j =0;j<1000;j++){
//            MyThread myThread = new MyThread();
//            new Thread(myThread).start();
//        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(MyThread.i);
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        MyThread1 myThread1 = new MyThread1();
        new Thread(myThread1).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Common.i);
    }
}
