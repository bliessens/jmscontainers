package be.cegeka.jms.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
class JmsContainerInspector implements ApplicationListener<ContextRefreshedEvent> {

    //    @Autowired
//    @Qualifier("bulkJmsContainer")
//    private JmsListenerContainerFactory bulk;
//    @Autowired
//    @Qualifier("dynamicJmsContainerFactory")
//    private JmsListenerContainerFactory dynamic;
    @Autowired
    private JmsListenerEndpointRegistry registry;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (String containerName : registry.getListenerContainerIds()) {
            System.out.println("JmsListenerContainer: " + containerName);
            final DefaultMessageListenerContainer container = (DefaultMessageListenerContainer) registry.getListenerContainer(containerName);
            System.out.println(" jmsContainer.class ? " + container.getClass().getSimpleName());
            System.out.println(" jmsContainer.autoStartup ? " + container.isAutoStartup());
            System.out.println(" jmsContainer.isRunning ? " + container.isRunning());
            System.out.println(" jmsContainer.isPubSubDomain ? " + container.isPubSubDomain());
            System.out.println(" jmsContainer.isAcceptMessagesWhileStopping ? " + container.isAcceptMessagesWhileStopping());
        }

    }
}
