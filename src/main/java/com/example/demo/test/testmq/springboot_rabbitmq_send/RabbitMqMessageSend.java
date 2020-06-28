package com.example.demo.test.testmq.springboot_rabbitmq_send;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RabbitMqMessageSend
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/28 21:22
 * @Version: 1.0
 */
@Component
public class RabbitMqMessageSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message,String routingKey,String exchange){
        CorrelationData correlationData = new CorrelationData("订单Id");
        rabbitTemplate.convertAndSend(exchange,routingKey,message,correlationData);
    }
}
