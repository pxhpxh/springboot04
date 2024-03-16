package com.example.springboot04.test;

import com.alibaba.fastjson.JSON;
import com.example.springboot04.Springboot04Application;
import com.example.springboot04.config.DeadLetterConfig;
import com.example.springboot04.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest(classes = Springboot04Application.class)
@RunWith(SpringRunner.class)
public class RabbitMqTest {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法



    @Test
    public  void  test1(){
        System.out.println(restTemplate);
    }


    @Test
    public  void  test2(){
        System.out.println(rabbitTemplate);
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TopicExchange", "TestDirectRouting", JSON.toJSONString(map));
        rabbitTemplate.convertAndSend("TestDirectQueue1",createTime);
        rabbitTemplate.convertAndSend("TestDirectQueue1",createTime);
        rabbitTemplate.convertAndSend("TestDirectQueue1",createTime);
    }

    @Test
    public  void  test21(){
        Object testDirectQueue1 = rabbitTemplate.receiveAndConvert("TestDirectQueue1");
        System.out.println(testDirectQueue1);
    }


    @Test
    public  void  test3(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange2", "topic.man", manMap);
    }


    @Test
    public  void  test4(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message:wo M A N ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange2", "topic.woman", manMap);
    }


    @Test
    public void publishExpire(){
        String msg = "dead letter expire";
        for (int i = 0; i < 12; i++) {
            msg = msg + i;

            rabbitTemplate.convertAndSend(DeadLetterConfig.NORMAL_EXCHANGE, "normal.abc", msg);

        }

    }








}
