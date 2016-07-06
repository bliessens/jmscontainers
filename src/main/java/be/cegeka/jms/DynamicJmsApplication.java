package be.cegeka.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import java.util.concurrent.Executors;

@SpringBootApplication(/*exclude = {JmsAutoConfiguration.class}*/)
public class DynamicJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicJmsApplication.class, args);
    }


    @Bean(name = "bulkJmsContainerFactory")
    public JmsListenerContainerFactory jmsBulkContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setTaskExecutor(Executors.newSingleThreadExecutor());
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId("bulk");
        factory.setAutoStartup(false);
//		factory.setConcurrency(Integer.toString(this.concurrency));
        return factory;
    }

    @Bean(name = "dynamicJmsContainerFactory")
    public JmsListenerContainerFactory jmsDynamicContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setTaskExecutor(Executors.newSingleThreadExecutor());
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId("dynamic");
        factory.setAutoStartup(false);
//		factory.setConcurrency(Integer.toString(this.concurrency));
        return factory;
    }
    @Bean(name = "advisoryJmsContainerFactory")
    public JmsListenerContainerFactory jmsAdvisoryContainer(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setTaskExecutor(Executors.newSingleThreadExecutor());
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId("advisory");
        factory.setAutoStartup(true);
//		factory.setConcurrency(Integer.toString(this.concurrency));
        return factory;
    }

}
