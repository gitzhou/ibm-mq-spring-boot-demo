package com.ibm.mq.spring.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author bjzquan
 */
@Component
public class Receiver {

    @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "mq1ListenerContainerFactory")
    public void receiveMessage1(String message) {
        System.out.println("DEV.QUEUE.1 received ~" + message + "~");
    }

    @JmsListener(destination = "DEV.QUEUE.2", containerFactory = "mq2ListenerContainerFactory")
    public void receiveMessage2(String message) {
        System.out.println("DEV.QUEUE.2 received ~" + message + "~");
    }
}
