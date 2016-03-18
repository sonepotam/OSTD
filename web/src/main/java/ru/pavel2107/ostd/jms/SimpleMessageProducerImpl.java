package ru.pavel2107.ostd.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import ru.pavel2107.ostd.dto.AccountTo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Date;

public class SimpleMessageProducerImpl implements  SimpleMessageProducer {
    
    private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageProducerImpl.class);
    
    protected JmsTemplate jmsTemplate;
    
    protected int numberOfMessages = 10;
    
    public void setNumberOfMessages(int numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }

    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(AccountTo[] list) throws JMSException {
            jmsTemplate.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    LOG.debug("Producer sends LIST: ");
                    for( AccountTo acc: list){
                        LOG.debug("   ->" + acc);
                    }
                    LOG.debug( "==========================");
                    return session.createObjectMessage( list);
                }
            });

    }
}
