package com.ibm.mq.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author bjzquan
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        // Send a message
        JmsTemplate jmsTemplate1 = context.getBean("jmsTemplate1",JmsTemplate.class);
        jmsTemplate1.convertAndSend("DEV.QUEUE.1", "Hello IBM MQ");
        JmsTemplate jmsTemplate2 = context.getBean("jmsTemplate2",JmsTemplate.class);
        jmsTemplate2.convertAndSend("DEV.QUEUE.2", "Hello IBM MQ");
    }
}
