package com.example.demo.test.testmq.springboot_rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RabbitMqConsumer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/28 21:27
 * @Version: 1.0
 */
@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = "queue1")
    public void getMessage(String message){
        System.out.println(message);
    }
}
