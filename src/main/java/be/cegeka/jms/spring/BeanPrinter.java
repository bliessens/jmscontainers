package be.cegeka.jms.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpoint;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

//@Component
class BeanPrinter implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("Bean: " + beanName);
        }
        System.out.println("------------- JmsLCFactory:");
        for (String beanName : context.getBeanNamesForType(JmsListenerContainerFactory.class)) {
            System.out.println(" " + beanName);
        }
        System.out.println("------------- MessageListenerContainer:");
        for (String beanName : context.getBeanNamesForType(MessageListenerContainer.class)) {
            System.out.println(" " + beanName);
        }
        System.out.println("------------- ConnectionFactory:");
        for (String beanName : context.getBeanNamesForType(ConnectionFactory.class)) {
            System.out.println(" " + beanName);
        }
        System.out.println("------------- MessageListeners:");
        for (String beanName : context.getBeanNamesForType(MessageListener.class)) {
            System.out.println(" " + beanName);
        }
        System.out.println("------------- JmsListenerEndpoint:");
        for (String beanName : context.getBeanNamesForType(JmsListenerEndpoint.class)) {
            System.out.println(" " + beanName);
        } System.out.println("------------- JmsListenerEndpointRegistry:");
        for (String beanName : context.getBeanNamesForType(JmsListenerEndpointRegistry.class)) {
            System.out.println(" " + beanName);
        }

    }
}
