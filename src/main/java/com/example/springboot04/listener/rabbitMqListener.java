package com.example.springboot04.listener;

import com.example.springboot04.config.DeadLetterConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName rabbitMqListener
 * @Description
 * @Author pxh
 * @Date 2024/2/26 17:24
 * @Version 1.0
 */

@Component
public class rabbitMqListener {

    @RabbitListener(queues = "TestDirectQueue1",containerFactory = "connectionFactory")
    public void consume1(String msg) throws IOException {
        System.out.println("接收到normal队列的消息：" + msg);
        //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }
    @RabbitListener(queues = "TestDirectQueue")
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到normal队列的消息：" + msg);
        //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }
}
