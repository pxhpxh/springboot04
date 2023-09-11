package com.example.springboot04.event;

import com.example.springboot04.Springboot04Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.engine.IterationStatusVar;

/**
 * @ClassName Test
 * @Description
 * @Author pxh
 * @Date 2023/5/18 19:00
 * @Version 1.0
 */
@SpringBootTest(classes = Springboot04Application.class)
@RunWith(SpringRunner.class)
public class Test {


    @Autowired
    TestPublish testPublish;

    @Autowired
    ApplicationEventPublisher  applicationEventPublisher ;

    @org.junit.Test
    public  void test1(){

        for(int i=0; i < 100; i++ ){
            TestParam testParam =  new TestParam();
            testParam.setEmail("哈" + i);
            TestEvent testEvent = new TestEvent(testParam);
            testPublish.publishEvent(testEvent);
        }

       // applicationEventPublisher.publishEvent(testEvent);

    }
}
