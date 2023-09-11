package com.example.springboot04.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestListener
 * @Description
 * @Author pxh
 * @Date 2023/5/18 18:36
 * @Version 1.0
 */

@EnableAsync
@Component
public class TestListener implements ApplicationListener<TestEvent> {

    @Async
    @Override
    public synchronized void onApplicationEvent(TestEvent testEvent) {
        System.out.println(Thread.currentThread().getName());
        TestParam param = (TestParam) testEvent.getSource();
        System.out.println(".......开始.......");
        System.out.println("发送邮件:"+param.getEmail());
        System.out.println(".......结束.....");
    }
}
