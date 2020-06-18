package com.example.demo.test.testthread;

import java.util.concurrent.*;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestCallable
 * @date 2020/4/29 14:58
 * @注释：
 */
public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
//        if (true){
//            throw new Exception(".....");
//        }
        Thread.sleep(2000);
        return "hahahaha";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future fetureTask = executorService.submit(new TestCallable());
        try {
            System.out.println(fetureTask.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
