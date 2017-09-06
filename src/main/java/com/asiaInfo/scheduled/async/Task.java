package com.asiaInfo.scheduled.async;

import com.asiaInfo.model.Message;
import com.asiaInfo.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

/**
 * Created by wxwall on 2017/9/4.
 */
@Component
public class Task {

    private Logger logger = Logger.getLogger(getClass());

    BlockingQueue<List<Message>> blockingQueue = new ArrayBlockingQueue<List<Message>>(300);


    @Autowired
    MessageService messageService;


    @Async("readExecutor")
    public Future<String> doTaskOne(Message message) throws Exception {
        logger.info("读任务开始");
        List<Message> messages = null;
        try {
            messages  = messageService.queryMessageByTypeCd(message);

        }catch (Exception e){
            e.printStackTrace();
        }
        blockingQueue.put(messages);
        return new AsyncResult<>( "任务一完成");
    }

    @Async("processExecutor")
    public Future<String> doTaskTwo() throws Exception {
        logger.info("处理任务开始");
       /* List<Message> messages = blockingQueue.take();
        List<Message> processMessage = messageService.processMessage(messages);*/
        return new AsyncResult<>("任务二完成");
    }



}
