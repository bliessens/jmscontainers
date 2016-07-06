package be.cegeka.jms.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class BulkConsumer {

    @JmsListener(id = "bulkJmsContainer", containerFactory = "bulkJmsContainerFactory", destination = "${queue.bulk}")
    public void onMessage(String text) {
        System.out.println("Bulk message processed");
    }
}
