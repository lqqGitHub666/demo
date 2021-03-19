package com.example.demo.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @ClassName: Producer
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/3/11 15:18
 * @Version: 1.0
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException,
            InterruptedException, MQBrokerException {
        // 创建生产者对象，指明了生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("simple");
        // 设置服务器地址
        producer.setNamesrvAddr(RocketMQConfig.NAME_SERVER);
        // 启动实例
        producer.start();

        for (int i = 0; i < 3; i++) {
            String str = "Hello RocketMQ";
            // 实例化消息对象
            Message message = new Message("topicTest", "tagA", (str + i).getBytes());
            // 发送消息
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }
        // 关闭生产者
        producer.shutdown();
        System.out.println(".................");
    }
}
