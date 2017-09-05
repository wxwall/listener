package com.asiaInfo.scheduled;

import com.asiaInfo.scheduled.async.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * Created by wxwall on 2017/9/4.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private Task task;

    public void task() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();

        while(true) {
            if(task1.isDone() && task2.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws Exception {
        task();
        System.out.println("当前时间：" + dateFormat.format(new Date()));
    }

}
