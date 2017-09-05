package com.asiaInfo.scheduled.async;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by wxwall on 2017/9/4.
 */
@Component
public class Task {

    private Logger logger = Logger.getLogger(getClass());


    @Async("readExecutor")
    public Future<String> doTaskOne() throws Exception {
        logger.info("开始做任务一");
        return new AsyncResult<>( "任务一完成");
    }

    @Async("processExecutor")
    public Future<String> doTaskTwo() throws Exception {
        logger.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        logger.debug(Thread.currentThread().getName() +"完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }



}
