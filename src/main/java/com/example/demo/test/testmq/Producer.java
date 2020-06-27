package com.example.demo.test.testmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/23 21:09
 * @Version: 1.0
 */
public class Producer {


    public static void sendByExchange(String message,String exchange,String routingKey) throws Exception {

        Connection connection = ConnectionUtil.getDefaultConnection();
        Channel channel = connection.createChannel();
        //声明队列
        //channel.queueDeclare(ConnectionUtil.QUEUE_NAME,true,false,false,null);
        // 声明exchange交换机
        //channel.exchangeDeclare(ConnectionUtil.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //交换机和队列绑定
        //channel.queueBind(ConnectionUtil.QUEUE_NAME, ConnectionUtil.EXCHANGE_NAME, "");
        //往队列里面发送消息
        channel.basicPublish(exchange, routingKey, null, message.getBytes());
        System.out.println("发送的信息为:" + message);
        channel.close();
        connection.close();
    }

    public static void declareDirect() throws Exception {
        String exchangeName = "exchangeDirect";
        String queue1 = "queue1";
        String queue2 = "queue2";
        String queue3 = "queue3";
        Connection connection = ConnectionUtil.getDefaultConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDelete(exchangeName);
        // 声明exchange交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);
        //声明队列
        channel.queueDeclare(queue1,true,false,false,null);
        channel.queueDeclare(queue2,true,false,false,null);
        channel.queueDeclare(queue3,true,false,false,null);
        //交换机和队列绑定
        channel.queueBind(queue1, exchangeName, "info.user");
        channel.queueBind(queue2, exchangeName, "debug.user");
        channel.queueBind(queue3, exchangeName, "error.user");
        channel.close();
        connection.close();
    }

    public static void declareFanout() throws Exception {
        String exchangeName = "exchangeFanout";
        String queueName = "testFanout";
        Connection connection = ConnectionUtil.getDefaultConnection();
        Channel channel = connection.createChannel();
        // 声明exchange交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT);
        //声明队列
        channel.queueDeclare(queueName,true,false,false,null);
        //交换机和队列绑定
        channel.queueBind(queueName, exchangeName, "");
        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        declareDirect();
    }
}
