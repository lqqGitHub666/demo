package com.example.demo.test.testthread;

import java.util.concurrent.TimeUnit;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestThreadLocal
 * @date 2020/4/28 17:32
 * @注释：
 */
public class TestThreadLocal {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {


        for (int i = 0; i <3 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TestThreadLocal.begin();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Cost: " + TestThreadLocal.end() + " mills");
                }
            }).start();
        }
    }

}
