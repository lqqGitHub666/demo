package com.example.demo.test.testmq.springboot_rabbitmq_send;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * @author 作者 lqq
 * @ClassName 类名 RabbitMessageConverter
 * @date 2020/6/29 17:54
 * @注释：
 */
public class RabbitMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        return new Message(JSON.toJSONBytes(object),messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        return JSON.parse(message.getBody());
    }
}
