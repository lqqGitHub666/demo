package com.example.demo.test.testmq.springboot_rabbitmq;

import com.example.demo.test.testmq.springboot_rabbitmq_send.RabbitMqMessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RabbitMqSendController
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/6/28 22:06
 * @Version: 1.0
 */
@RestController
public class RabbitMqSendController {

    @Autowired
    RabbitMqMessageSend rabbitMqMessageSend;

    @GetMapping("/rabbit/send")
    public String send(String message){
        rabbitMqMessageSend.sendMessage(message,"info.user","exchangeDirect");
        return null;
    }
}
