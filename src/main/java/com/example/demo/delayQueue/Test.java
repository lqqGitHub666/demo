package com.example.demo.delayQueue;


import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        DelayOrderWorker work1 = new DelayOrderWorker();// 任务1
        DelayOrderWorker1 work2 = new DelayOrderWorker1();// 任务2
        DelayOrderWorker work3 = new DelayOrderWorker();// 任务3
        // 延迟队列管理类，将任务转化消息体并将消息体放入延迟对列中等待执行
        DelayOrderQueueManager manager = DelayOrderQueueManager.getInstance();


        manager.put(work1, 6000, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(2);
        manager.put(work2, 3000, TimeUnit.MILLISECONDS);
        manager.put(work3, 9000, TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(15);
        System.out.println("-------延时15秒后添加新任务-----");

        manager.put(work3, 9000, TimeUnit.MILLISECONDS);
    }

}