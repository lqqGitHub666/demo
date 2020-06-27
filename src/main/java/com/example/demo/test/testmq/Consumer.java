package com.example.demo.test.testmq;

import com.rabbitmq.client.*;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @ClassName: Producer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/23 21:22
 * @Version: 1.0
 */
public class Consumer {

    public static void getMessage(String queue) throws Exception {
        Connection connection = ConnectionUtil.getDefaultConnection();
        Channel channel = connection.createChannel();
        if (!StringUtils.isEmpty(queue)){
            channel.queueDeclare(queue,true,false,false,null);
        }
        DefaultConsumer deliverCallback = new DefaultConsumer(channel) {
            //envelope 消息的相关信息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "UTF-8"));
                System.out.println("消息消费成功");
                //multiple 是否批量确认
//                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        //开始消费 autoAck:是否自动确认消费被成功消费，是 true ，否 false
        channel.basicConsume(queue,true,deliverCallback);
//        channel.close();
//        connection.close();
    }


    public static void main(String[] args) throws Exception {
//        Producer.sendByExchange("hehe");
//        getMessage();
    }

}
