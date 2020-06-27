package com.example.demo.test.testmq;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName: TestRabbitMq
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/23 21:23
 * @Version: 1.0
 */
public class TestRabbitMq {

    @Test
    public void testProducer() throws Exception {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Producer.sendByExchange(new Date().toString()+"\n用户lqq说："+scanner.next(),"exchangeFanout","");
        }
    }

    @Test
    public void testConsumer() throws Exception {
//        Producer.sendByExchange("hehe");
//        Consumer.getMessage();
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Producer.sendByExchange(new Date().toString()+"\n用户px说："+scanner.next(),"exchangeFanout","");
        }
    }

    public static void main(String[] args) throws Exception {
        Producer.sendByExchange("debug","exchangeDirect","debug.user");
    }
}
