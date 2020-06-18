package com.example.demo.test.testthread.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 作者 lqq
 * @ClassName 类名 ReadWriteLockDemo
 * @date 2019/10/15 19:29
 * @注释：
 */
public class ReadWriteLockDemo {

    private Map<String,Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();


    private Lock rl = rwl.readLock();

    private Lock wl = rwl.writeLock();

    public Object get(String key){
        rl.lock();
        try{
            return map.get(key);
        }finally {
            rl.unlock();
        }
    }

    public void put(String key,Object value){
        wl.lock();
        try{
            map.put(key,value);
        }finally {
            wl.unlock();
        }
    }

    /**
     * 锁降级
     * 锁降级是指写锁降级为读锁
     * 在写锁没有释放的时候，获取到读锁，再释放写锁
     *
     *锁升级（ReentrantReadWriteLock不支持锁升级）
     * 把读锁升级为写锁
     * 在读锁没有释放的时候，获取到写锁，再释放读锁
     */

    private volatile boolean isUpdate;
    public void readWrite(){
        rl.lock();
        if (isUpdate){
            rl.unlock();
            wl.lock();
            map.put("xxx","xxx");
            rl.lock();
            wl.unlock();
        }
        Object object = map.get("xxx");
        System.out.println(object);
        rl.unlock();
    }
}
