package com.example.demo.test.testthread;

/**
 * @author 作者 lqq
 * @ClassName 类名 MyThread1
 * @date 2020/1/9 9:33
 * @注释：
 */
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        while (Common.i<100){
        }
        System.out.println("出来了");
    }


//    private  static boolean  keepRunning = true;

//    public static void main(String[] args)  throws Exception {
//        new Thread(
//                ()->{
//                    while (keepRunning){
//                        //do something
//                    }
//                    System.out.println("循环停止");
//                }
//        ).start();
//        Thread.sleep(1000);
//        new Thread(
//                ()->{
//                    keepRunning = false;
//                    System.out.println("修改keepRunning");
//                }
//        ).start();
//        Thread.sleep(1000);
//        System.out.println(keepRunning);
//        System.out.println("下达循环停止指令");
//    }
}
