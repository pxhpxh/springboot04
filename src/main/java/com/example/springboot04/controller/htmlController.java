package com.example.springboot04.controller;

import com.example.springboot04.event.TestEvent;
import com.example.springboot04.event.TestParam;
import com.example.springboot04.event.TestPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class htmlController {
    @Autowired
    TestPublish testPublish;
    @RequestMapping("/pay")
    public String test(){
        for(int i=0 ;i < 100; i ++){
            System.out.println(i);
            TestParam testParam =  new TestParam();
            testParam.setEmail("哈哈哈");
            TestEvent testEvent = new TestEvent(testParam);
            testPublish.publishEvent(testEvent);
        }
        return "pay";
    }
}
