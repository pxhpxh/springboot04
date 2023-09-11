package com.example.springboot04.threads;


import cn.hutool.cron.task.Task;
import com.example.springboot04.Springboot04Application;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Description  测试类
 * @Author pxh
 * @Date 2023/5/8 20:17
 * @Version 1.0
 */
@SpringBootTest(classes = Springboot04Application.class)
public class Test1 {

    @Test
    public  void test1(){
        FutureTask<Integer> future = new FutureTask<>(new CallableDemo(100));

        Thread thread = new Thread(future);
        thread.start();

        //获取任务执行返回值
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(result);


    }


    @Test
    public  void test2(){
        ExecutorService pool = new ThreadPoolExecutor(3, 6, 10,//直接提交队列，队列中不能存任务
                TimeUnit.SECONDS,new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 3; i++) {
            pool.execute(new ThreadDemo());
        }
    }


    //使用ArrayBlockingQueue有界任务队列，若有新的任务需要执行时，线程池会创建新的线程，直到创建的线程数量达到corePoolSize时，则会将新的任务加入到等待队列中。
    //若等待队列已满，即超过ArrayBlockingQueue初始化的容量，则继续创建线程，直到线程数量达到maximumPoolSize设置的最大线程数量，若大于maximumPoolSize，则执行拒绝策略。
    @Test
    public  void test3(){
        ExecutorService pool = new ThreadPoolExecutor(5, 30, 5,//直接提交队列，队列中不能存任务
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(80), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
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


    //无界任务队列，线程池的任务队列可以无限制的添加新的任务，而线程池创建的最大线程数量就是你corePoolSize设置的数量，
    // 也就是说在这种情况下maximumPoolSize这个参数是无效的，哪怕你的任务队列中缓存了很多未执行的任务，当线程池的线程数达到corePoolSize后，就不会再增加了；
    // 若后续有新的任务加入，则直接进入队列等待，当使用这种任务队列模式时，一定要注意你任务提交与处理之间的协调与控制，不然会出现队列中的任务由于无法及时处理导致一直增长，
    // 直到最后资源耗尽的问题。
    @Test
    public  void test4(){
        ExecutorService  pool = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
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
