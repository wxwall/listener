package com.asiaInfo.service;

import com.asiaInfo.model.Message;

import java.util.List;

/**
 * wuxw
 */
public interface MessageService {

    List<Message> queryMessage(Message message);
}