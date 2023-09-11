package com.example.springboot04.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName TestEvent
 * @Description
 * @Author pxh
 * @Date 2023/5/18 18:35
 * @Version 1.0
 */


public class TestEvent extends ApplicationEvent {

    private TestParam source;

    public TestEvent(TestParam source) {
        super(source);
        this.source = source;
    }

}

