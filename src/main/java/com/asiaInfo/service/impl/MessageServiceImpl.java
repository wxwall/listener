package com.asiaInfo.service.impl;

import com.asiaInfo.mapper.MessageMapper;
import com.asiaInfo.model.Message;
import com.asiaInfo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wxwall on 2017/9/1.
 */
@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private MessageMapper messageMapper;


    @Override
    public List<Message> queryMessage(Message message) {
        return messageMapper.findAll();
    }

    @Override
    public List<Message> queryMessageByTypeCd(Message message) throws Exception {
        int typeCd = message.getMsgTypeCd();
        if(typeCd == 0){
            throw new Exception("MsgTypeCd不能为0");
        }
        String tableName = getTableName(typeCd);
        tableName = "intf_co_archive_msg";
        return messageMapper.findAllByTableName(tableName);
    }

    private String getTableName(int typeCd) {
        return null;
    }


    @Override
    public List<Message> processMessage(List<Message> messages) {
        return null;
    }
}
