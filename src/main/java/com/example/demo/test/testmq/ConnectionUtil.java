package com.example.demo.test.testmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: ConnectionUtil
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/23 21:07
 * @Version: 1.0
 */
public class ConnectionUtil {

    public static final String QUEUE_NAME  = "testQueue";

    public static  final  String EXCHANGE_NAME = "exchange";

    private static Connection connection;

    static {
        //创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置rabbitmq 服务端所在地址 我这里在本地就是本地
        connectionFactory.setHost("114.215.209.214");
        //设置端口号，连接用户名，虚拟地址等
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lqq");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("testhost");
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        //创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置rabbitmq 服务端所在地址 我这里在本地就是本地
        connectionFactory.setHost("192.168.72.3");
        //设置端口号，连接用户名，虚拟地址等
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lqq");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("testhost");
        return connectionFactory.newConnection();
    }

    public static Connection getDefaultConnection(){
        return connection;
    }

}
