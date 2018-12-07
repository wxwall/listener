package com.asiaInfo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义异步调用（线程池配置）
 * Created by wxwall on 2017/9/4.
 */
@Configuration
@EnableAsync
public class AsynConfig {

    /** Set the ThreadPoolExecutor's core pool size. */
    private int corePoolSize_read = 1;
    /** Set the ThreadPoolExecutor's maximum pool size. */
    private int maxPoolSize_read = 2;
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
    private int queueCapacity_read = 100;

    private String ThreadNamePrefix_read = "readExecutor-";


    /** Set the ThreadPoolExecutor's core pool size. */
    private int corePoolSize_process = 1;
    /** Set the ThreadPoolExecutor's maximum pool size. */
    private int maxPoolSize_process = 2;
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
    private int queueCapacity_process = 100;

    private String ThreadNamePrefix_process = "proExecutor-";



    //读线程池配置
    @Bean(name = "readExecutor")
    public Executor readExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize_read);
        executor.setMaxPoolSize(maxPoolSize_read);
        executor.setQueueCapacity(queueCapacity_read);
        executor.setThreadNamePrefix(ThreadNamePrefix_read);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }


    //处理侦听线程池配置
    @Bean(name = "processExecutor")
    public Executor processExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize_process);
        executor.setMaxPoolSize(maxPoolSize_process);
        executor.setQueueCapacity(queueCapacity_process);
        executor.setThreadNamePrefix(ThreadNamePrefix_process);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }
}
