package com.example.demo.delayQueue;

public class DelayOrderWorker1 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        //相关业务逻辑处理
        System.out.println(Thread.currentThread().getName()+" do something ……++++++++");
    }
}
