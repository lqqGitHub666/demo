package com.example.demo.test.testthread;

import com.example.demo.test.testthread.fairlock.MyFairLock;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestA
 * @date 2019/9/25 20:57
 * @注释：
 * 线程安全性问题总结：
 *
 * 出现线程安全性问题的条件
 * 解决线程安全性问题的条件
 *     必须多线程的条件下
 *     必须有共享资源
 *     对共享资源进行非原子性操作
 * 解决线程安全性问题的途径
 *     synchronized(偏向锁，轻量级锁，重量级锁)
 *     volatile
 *     JDK提供的原子类
 *     使用Lock(共享锁，排它锁)
 * 认识的“* 锁”
 *     偏向锁
 *     轻量级锁
 *     重量级锁
 *     重入锁
 *     自旋锁
 *     共享锁
 *     独占锁
 *     排他锁
 *     读写锁
 *     公平锁
 *     非公平锁
 *     死锁
 *     活锁
 *
 */
public class TestA {

  /** private MyLock lock = new MyLock()*/

    private MyFairLock lock = new MyFairLock();

    private void a() throws InterruptedException {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    private void b() throws InterruptedException {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    private int a;

    public int add() throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(1000);
            return a++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            lock.unlock();
        }
    }

    static final int SHARED_SHIFT   = 16;
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    /** Returns the number of shared holds represented in count  */
    static int sharedCount(int c)    { return c >>> SHARED_SHIFT; }

    public static void main(String[] args) {
        System.out.println(sharedCount(4));
//        TestA testA = new TestA();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    testA.a();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        testA.add();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getId() + "----" + testA.a);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        testA.add();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getId() + "----" + testA.a);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        testA.add();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getId() + "----" + testA.a);
//                }
//            }
//        }).start();


    }
}
