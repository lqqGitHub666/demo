package com.example.demo.test.testmq.springboot_rabbitmq_send;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


/**
 * @ClassName: RabbitCallBack
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/28 21:52
 * @Version: 1.0
 */
public class RabbitCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(this.getClass().getName());
        //消息是否发送成功
        System.out.println(b);
        //失败的原因
        System.out.println(s);
        //发送消息业务对象的相关数据
        System.out.println(correlationData);
        System.out.println(this.getClass().getName());
    }
}
