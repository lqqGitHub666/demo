package com.example.demo.test.testthread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 作者 lqq
 * @ClassName 类名 MyThread
 * @date 2019/8/6 16:44
 * @注释：
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        test();
    }

    public void test(){
        for (int j = 0;j<105;j++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Common.i++;
        }
    }
}
