package be.cegeka.jms.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ManagedResource
@Component
public class JmsContainerToggler implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private JmsListenerEndpointRegistry registry;

    private DefaultMessageListenerContainer bulk;
    private DefaultMessageListenerContainer dynamic;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        bulk = (DefaultMessageListenerContainer) registry.getListenerContainer("bulkJmsContainer");
        dynamic = (DefaultMessageListenerContainer) registry.getListenerContainer("dynamicJmsContainer");
    }

    @ManagedOperation
    public void startBulk() {
        if (!bulk.isRunning()) {
            System.out.println("Starting bulk");
            bulk.start();
        }
    }

    @ManagedOperation
    public void stopBulk() {
        if (bulk.isRunning()) {
            System.out.println("Stopping bulk");
            bulk.stop();
        }
    }

    @ManagedOperation
    public void startDynamic() {
        if (!dynamic.isRunning()) {
            System.out.println("Starting dynamic");
            dynamic.start();
        }
    }

    @ManagedOperation
    public void stopDynamic() {
        if (dynamic.isRunning()) {
            System.out.println("Stopping dynamic");
            bulk.stop();
        }
    }
}
