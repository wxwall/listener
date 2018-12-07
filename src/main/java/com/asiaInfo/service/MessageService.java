package com.asiaInfo.service;

import com.asiaInfo.exception.MyException;
import com.asiaInfo.model.Message;

import java.util.List;

/**
 * wuxw
 */
public interface MessageService {

    List<Message> queryMessage(Message message);

    List<Message> queryMessageByTypeCd(Message typeCd) throws Exception;

    List<Message> processMessage(List<Message> messages) throws MyException;
}
