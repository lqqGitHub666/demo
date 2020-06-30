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
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        //message:发送的消息+message
        System.out.println(message);
        //状态码
        System.out.println(replyCode);
        //错误信息
        System.out.println(replyText);
        //交换机
        System.out.println(exchange);
        //路由键
        System.out.println(routingKey);


    }
}
