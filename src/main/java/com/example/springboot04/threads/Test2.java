package com.example.springboot04.threads;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test2
 * @Description
 * @Author pxh
 * @Date 2023/5/8 21:11
 * @Version 1.0
 */

public class Test2 {

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(5, 20, 5,//直接提交队列，队列中不能存任务
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(200), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 100; i++) {
                ThreadDemo threadDemo = new ThreadDemo();
                pool.execute(threadDemo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
