package com.asiaInfo.async;

import com.asiaInfo.Application;
import com.asiaInfo.model.Message;
import com.asiaInfo.scheduled.async.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.Future;

/**
 * Created by wxwall on 2017/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TaskTest {

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {
        Message msg = new Message();
        msg.setMsgTypeCd(103);
        msg.setRoute("8440000");
        Future<String> stringFuture = task.doTaskOne(msg);
        Future<String> stringFuture1 = task.doTaskTwo();

        while (true) {
            if(stringFuture.isDone() && stringFuture1.isDone()){
                break;
            }
        }

    }


}
