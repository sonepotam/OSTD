package ru.pavel2107.ostd.jms;

import ru.pavel2107.ostd.dto.AccountTo;

import javax.jms.JMSException;

/**
 * Created by admin on 03.03.2016.
 */
public interface SimpleMessageProducer {
    public void sendMessage(AccountTo[] list) throws JMSException;
}
