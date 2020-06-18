package com.example.demo.test;

/**
 * @author 作者 lqq
 * @ClassName 类名 As
 * @date 2020/4/27 18:15
 * @注释：
 */

import java.util.Map.Entry;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    private volatile boolean flag = true;
    /**
     * 银行流水处理服务类
     **
     @authorftf
      **
     /
     publicclass BankWaterService implements Runnable {
     /**
      * 创建4个屏障，处理完之后执行当前类的run方法
     */
    public CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer>sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();
    private void count() {
        for (int i = 0; i< 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银流数据，计算代码省略
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 银流计算完成，插入一个屏障
                    try {
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
        for (Entry<String, Integer>sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        } // 将结果输出
        sheetBankWaterCount.put("result", result);
//        System.out.println(result);
//        executor.shutdown();
        flag = false;
    }
    public static void main(String[] args) throws InterruptedException {

        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
        while (bankWaterCount.flag){
            Thread.sleep(1000);
        }
        System.out.println(bankWaterCount.sheetBankWaterCount.get("result"));
        System.out.println("eiheihei");
        bankWaterCount.executor.shutdown();

    }
}
