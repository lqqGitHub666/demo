package com.example.demo.test.testmq.rabbitmqconfig;

import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitCallBack;
import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitReturnCallBack;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        //开启失败回调
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(rabbitReturnCallBack);
        return rabbitTemplate;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchangeTest");
    }

    @Bean
    public Queue queue(){
        return new Queue("queueTest");
    }
 }
