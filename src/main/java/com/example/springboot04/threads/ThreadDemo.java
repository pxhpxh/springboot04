package com.example.springboot04.threads;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadDemo
 * @Description
 * @Author pxh
 * @Date 2023/5/8 20:31
 * @Version 1.0
 */

class ThreadDemo implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName());
       TimeUnit.SECONDS.sleep(5);
    }
}

