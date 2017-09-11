package com.asiaInfo.scheduled;

import com.asiaInfo.common.ConstantsParam;
import com.asiaInfo.model.Message;
import com.asiaInfo.scheduled.async.Task;
import com.asiaInfo.service.MessageService;
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
    MessageService messageService;

    @Autowired
    private ConstantsParam Constants;


    @Autowired
    private Task task;

    public void task()  {

        long start = System.currentTimeMillis();

        int typeCds [] = Constants.getMsgType();
        String teamKeys [] = Constants.getTeamKeys();

        Future<String> task1 = null;
        Future<String> task2 = null;
        for (int typeCd : typeCds) {
            Message message = new Message();
            message.setMsgTypeCd(typeCd);
            for (String teamKey : teamKeys){
                message.setTeamKey(teamKey);
                try {
                    task1 = task.doTaskOne(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    task2 = task.doTaskTwo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        while(true) {
            if(task1.isDone() && task2.isDone()) {
                // 任务都调用完成，退出循环等待
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
