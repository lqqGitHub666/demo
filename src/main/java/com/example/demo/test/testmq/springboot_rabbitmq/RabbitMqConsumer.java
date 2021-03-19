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
//@Component
public class RabbitMqConsumer {


    @RabbitListener(queues = "queue",containerFactory = "simpleRabbitListenerContainerFactory")
    public void getMessageA(Message message, Channel channel) throws Exception{
        //设置消息预取
        channel.basicQos(10);
        System.out.println(message.getBody());
        if (consumeMessage()){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }else {
            //这里requeue参数表示是否退回到原来的队列ture：是 ， false：否
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
            //确认消息被成功消费
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
     *      channel.basicQos(10);设置消息预取条数位10条----java client设置方式
     *      springboot设置方式：simpleRabbitListenerContainerFactory.setPrefetchCount(500);
     *      消息预取的最大数限制在2500条，消息预取并批量确认可以提高消费性能，但是将会导致程序的可靠性下降，
     *      即，如果预取数量为2500条，当消费2000条时出现报错，则会导致2000条数据未能确认，但是程序已经报错
     *      了，导致下次消费还会重复消费这2000条消息，导致业务出错，这里需要业务方自己实现幂等，保证被消费的
     *      消息不再重复消费，或者缓存每次消费的消息id，在程序报错时，try catch中处理最后一条正常消费的消息，
     *      对该条消息进行消息确认，也可以解决问题
     *
     *
     *
     *  备用交换机：声明交换机的时候设置备用交换机，用于接收无法被主交换机接受的消息或接收失败的消息
     *  死信交换机：声明交换机的时候设置死信交换机，3种类型的消息会进入死信交换机：
     *                             1.被拒绝又没有退回到原队列里面则进入
     *                             2.退回的消息已经是过期的消息，则进入死信交换机
     *                             3.退回的消息此时，消息队列已经满了，则消息无处存放则进入死信交换机
     *
     */
}
