package com.example.demo.test.testmq.consumer;

import com.example.demo.test.testmq.Consumer;

/**
 * @ClassName: Consumer1
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/27 21:15
 * @Version: 1.0
 */
public class Consumer1 {

    public static void main(String[] args) throws Exception {
        Consumer.getMessage("queue1");
    }

}
