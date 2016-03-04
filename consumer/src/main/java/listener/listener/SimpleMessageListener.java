package listener.listener;

import javax.jms.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pavel2107.ostd.dto.AccountTo;

public class SimpleMessageListener implements MessageListener {
    
    private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageListener.class);

    public void onMessage(Message message) {

        System.out.println( "message received");
        if (message instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) message).getText());
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            if (message instanceof ObjectMessage) {
                Object object = null;
                try {
                    object = ((ObjectMessage) message).getObject();
                    System.out.println( object.getClass().getCanonicalName());
                    if( object instanceof AccountTo[]){
                        AccountTo[] list = (AccountTo[]) object;
                        System.out.println("Received account list");
                        for( AccountTo acc: list){
                            System.out.println( "    ->" + acc);
                        }
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
