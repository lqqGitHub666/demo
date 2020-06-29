package com.example.demo.test.testmq.springboot_rabbitmq_send;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author 作者 lqq
 * @ClassName 类名 RabbitReturnCallBack
 * @date 2020/6/29 14:21
 * @注释：
 */
public class RabbitReturnCallBack implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
