package com.example.springboot04.threads;

/**
 * @ClassName ThreadDemo
 * @Description
 * @Author pxh
 * @Date 2023/5/8 20:31
 * @Version 1.0
 */

class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

