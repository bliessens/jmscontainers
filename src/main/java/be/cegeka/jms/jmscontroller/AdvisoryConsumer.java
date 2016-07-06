package be.cegeka.jms.jmscontroller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class AdvisoryConsumer {

    @JmsListener(id = "bulkJmsContainer", containerFactory = "advisoryJmsContainerFactory", destination = "ActiveMQ.Advisory.MessageDelivered.Queue.${queue.bulk}")
    public void onAdvisory(String message)  {

    }
}
