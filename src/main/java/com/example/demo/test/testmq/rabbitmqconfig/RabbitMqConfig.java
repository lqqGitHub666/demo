package com.example.demo.test.testmq.rabbitmqconfig;

import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitCallBack;
import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitMessageConverter;
import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitReturnCallBack;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.PublisherCallbackChannel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RabbitMqConfig
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/28 21:12
 * @Version: 1.0
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        return new TomcatServletWebServerFactory(80);
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        //设置rabbitmq 服务端所在地址 我这里在本地就是本地
        connectionFactory.setHost("192.168.72.3");
        //设置端口号，连接用户名，虚拟地址等
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lqq");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("testhost");
        //开启发送方确认模式
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public RabbitCallBack rabbitCallBack(){
        return new RabbitCallBack();
    }

    @Bean
    public RabbitReturnCallBack rabbitReturnCallBack(){
        return new RabbitReturnCallBack();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         RabbitCallBack rabbitCallBack,
                                         RabbitReturnCallBack rabbitReturnCallBack){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置回调函数
        rabbitTemplate.setConfirmCallback(rabbitCallBack);
        //开启失败回调模式
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(rabbitReturnCallBack);
        //设置数据序列化方式
        rabbitTemplate.setMessageConverter(new RabbitMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchangeTest");
    }

    //定义消息队列，并配置消息队列
    @Bean
    public Queue queue(){
        Map<String,Object> map = new HashMap<>();
        //设置死信队列
        map.put("x-dead-letter-exchange","deadExchange");
        //设置死信消息的重新定义的消息路由键
        map.put("x-dead-letter-routing-key","testdead.key");
        return new Queue("queueTest",true,false,false,map);
    }

    //定义死信交换机
    @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange("deadExchange");
        return directExchange;
    }

    //用于接收死信交换机消息的的消息队列
    @Bean
    public Queue queue1(){
        return new Queue("queueTest",true,false,false,null);
    }

    //绑定死信交换机和消息队列的关系
    @Bean
    public Binding binding(){
        Binding binding = BindingBuilder.bind(queue1()).to(directExchange()).with("testdead.key");
        return binding;
    }

    //设置消费者属性
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
//        simpleMessageListenerContainer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//
//            }
//        });
//        simpleMessageListenerContainer.addQueueNames("","","");
//        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return simpleMessageListenerContainer;
//    }

    //配置消息确认
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        //设置连接工厂
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory());
        //设置手动消息确认
        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //设置消息预取的数量
        simpleRabbitListenerContainerFactory.setPrefetchCount(500);
        return simpleRabbitListenerContainerFactory;
    }
 }
