package com.example.springboot04.listener;


import com.example.springboot04.config.DeadLetterConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class DeadListener {

    @RabbitListener(queues = DeadLetterConfig.NORMAL_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到normal队列的消息：" + msg);
        //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }

    @RabbitListener(queues = DeadLetterConfig.DEAD_QUEUE)
    public void DeadListener(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到normal队列的消息：" + msg);
        //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
    }
}


