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
    public void getMessageA(Message message, Channel channel) throws Exception{
        //设置消息预取
        channel.basicQos(10);
        System.out.println(message.getBody());
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

    @RabbitListener(queues = "queue",containerFactory = "simpleRabbitListenerContainerFactory")
    public void getMessageB(Message message, Channel channel) throws Exception{
        //设置消息预取
        channel.basicQos(1);
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

    /**
     * 消息消费完需要确认，确认完成后消息将不会被再次消费，如果未确认，则消息会进入未确认队列，
     * 如果此时消费此消息的消费者宕机，则消息会默认回到未消费队列。
     * 消息退回：当消息消费业务失败，消息不能被确认，则需要执行消息退回，否则消息将永远留在未
     * 确认的队列里面，这样显然是不合理的，则提供消息退回操作，手动将消息退回到带消费队列，等待
     * 消费者下次消费。
     *
     *
     * 消息预取：
     *      channel.basicQos(10);设置消息预取条数位10条
     *
     */
}
