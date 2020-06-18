package com.example.demo.test.testthread.fairlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 lqq
 * @ClassName 类名 MyFairLock
 * @date 2019/10/15 15:46
 * @注释：公平不可重入的锁
 */
public class MyFairLock {

    private boolean isLocked = false;

    private Thread lockingThread = null;

    private int lockCount = 0;

    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException{
        final Thread currentThread = Thread.currentThread();
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this){
            waitingThreads.add(queueObject);
        }
        while (isLockedForThisThread){
            synchronized (this){
                isLockedForThisThread = isLocked || (waitingThreads.get(0) != queueObject);
                if (!isLockedForThisThread || currentThread == lockingThread){
                    isLocked = true;
                    lockCount ++;
                    lockingThread = Thread.currentThread();
                    waitingThreads.remove(queueObject);
                    return;
                }
            }
            try{
                queueObject.doWait();
            }catch (InterruptedException e){
                synchronized (this){
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock(){
        if (this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        lockCount --;
        if (lockCount == 0){
            isLocked = false;
            lockingThread = null;
        }
        if (waitingThreads.size()>0){
            waitingThreads.get(0).doNotify();
        }
    }

}
