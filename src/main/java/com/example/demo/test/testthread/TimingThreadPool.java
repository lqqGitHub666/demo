package com.example.demo.test.testthread;

import java.util.concurrent.*;

/**
 * @author 作者 lqq
 * @ClassName 类名 TimingThreadPool
 * @date 2020/5/6 10:32
 * @注释：
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    public TimingThreadPool() {
        super(1, 1, 0, TimeUnit.SECONDS, null);
    }

    @Override
    public void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }
}
