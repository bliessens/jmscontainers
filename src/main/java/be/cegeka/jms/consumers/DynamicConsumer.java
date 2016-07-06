package be.cegeka.jms.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DynamicConsumer {

    @JmsListener(id = "dynamicJmsContainer", containerFactory = "dynamicJmsContainerFactory", destination = "${queue.dynamic}")
    public void onMessage(String text) {
        System.out.println("Dynamic message processed");
    }
}
