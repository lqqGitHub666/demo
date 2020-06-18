package com.example.demo.test.testthread.fairlock;

/**
 * @author 作者 lqq
 * @ClassName 类名 QueueObject
 * @date 2019/10/15 15:43
 * @注释：
 */
public class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException{
        while (!isNotified){
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify(){
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object o){
        return this == o;
    }
}
