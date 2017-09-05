package com.asiaInfo.web;


import com.asiaInfo.model.Message;
import com.asiaInfo.service.MessageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;




    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public List<Message> queryMessage(@Param(value = "rout") String rout) {
        System.out.println("查询第三个数据源");
        Message message = new Message();
        message.setRoute(rout);
        return messageService.queryMessage(message);
    }

}