package listener;

import javax.jms.Connection;
import javax.jms.JMSException;

import listener.listener.SimpleMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class ConsumerApp {
	

    public static void main(String[] args) throws JMSException {

        String url = "tcp://localhost:61617";
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( url);
        Connection connection = connectionFactory.createConnection();
        connection.start();


        connection.stop();

        String[] beans = { "/META-INF/spring/consumer-jms-context.xml"} ;

        ApplicationContext context = new ClassPathXmlApplicationContext( beans, ConsumerApp.class);

    }
    
}
