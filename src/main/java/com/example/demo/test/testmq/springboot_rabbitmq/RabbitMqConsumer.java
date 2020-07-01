package com.example.demo.test.testmq.springboot_rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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


    @RabbitListener(queues = "queue",containerFactory = "simpleRabbitListenerContainerFactory")
    public void getMessage(Message message, Channel channel) throws Exception{
        System.out.println(message);
        if (consumeMessage()){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }else {
            //批量退回
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            //单挑退回
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }

    //消费消息
    public boolean consumeMessage(){
        return true;
    }
}
