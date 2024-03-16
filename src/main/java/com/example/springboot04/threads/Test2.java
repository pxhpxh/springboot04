package com.example.springboot04.threads;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @ClassName Test2
 * @Description
 * @Author pxh
 * @Date 2023/5/8 21:11
 * @Version 1.0
 */

public class Test2 {

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(10, 20, 30,//队列满了就会新建线程
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(200), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i < 100; i++) {
                ThreadDemo threadDemo = new ThreadDemo();
                pool.execute(threadDemo);
                //Future<Integer> future = pool.submit(new CallableDemo(100));
                //System.out.println(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
