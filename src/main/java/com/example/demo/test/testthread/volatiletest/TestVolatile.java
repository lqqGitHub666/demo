package com.example.demo.test.testthread.volatiletest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestVolatile
 * @date 2020/5/8 9:38
 * @注释：
 */
public class TestVolatile {

    private static Logger logger = LogManager.getLogger(TestVolatile.class);
    private volatile List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.strings.add("11");

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    testVolatile.strings.add("i");
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (testVolatile.strings.size() == 11){
                        logger.info(22);
                        break;
                    }
                }
            }
        }).start();
    }

}
