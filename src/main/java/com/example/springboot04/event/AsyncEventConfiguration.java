package com.example.springboot04.event;

/**
 * @ClassName AsyncEventConfiguration
 * @Description  使用异步事件需要的配置
 * @Author pxh
 * @Date 2023/5/18 19:47
 * @Version 1.0
 */

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhengbingyuan
 * @date 2023/2/6
 */
//@Configuration
//@RequiredArgsConstructor
public class AsyncEventConfiguration {
    //@Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(BeanFactory beanFactory) {
        SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        //设置线程池
        applicationEventMulticaster.setTaskExecutor(eventExecutor());
        return applicationEventMulticaster;
    }

   // @Bean
    public TaskExecutor eventExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        int corePoolSize = 5;
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        //最大线程数
        int maxPoolSize = 10;
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        //队列容量
        int queueCapacity = 40;
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        //拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //线程名前缀
        String threadNamePrefix = "eventExecutor-";
        threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 使用自定义的跨线程的请求级别线程工厂类19
        int awaitTerminationSeconds = 5;
        threadPoolTaskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}

