package com.example.springboot04.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "TestDirectQueue1")//监听的队列名称 TestDirectQueue
public class Receiver {

    @RabbitHandler
    public void process(Object testMessage) {
        System.out.println("DirectReceiver消费者收到消息2  : " + testMessage.toString());
    }

}
