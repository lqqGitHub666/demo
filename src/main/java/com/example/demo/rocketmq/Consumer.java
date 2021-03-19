package com.example.demo.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/3/11 15:21
 * @Version: 1.0
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        // 创建消费者对象，指明了消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("simple");
        // 设置服务器地址
        consumer.setNamesrvAddr(RocketMQConfig.NAME_SERVER);
        // 订阅指定主题
        consumer.subscribe("topicTest","*");
        // 注册消息监听事件
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

//                System.out.println("msg:"+msgs);
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者
        consumer.start();
    }
}
