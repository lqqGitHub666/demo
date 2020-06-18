package com.example.demo.test.testthread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 作者 lqq
 * @ClassName 类名 MyLock
 * @date 2019/9/25 20:48
 * @注释：
 */
public class MyLock implements Lock {

    private boolean isLocked = false;

    private Thread lockBy = null;

    private int lockCount = 0;
    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        while (isLocked && currentThread != lockBy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()){
            lockCount--;
            if (lockCount == 0){
                isLocked = false;
                notify();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
