package com.ibm.mq.spring.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author bjzquan
 */
@Component
public class Receiver {

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        System.out.println("DEV.QUEUE.1 received ~" + message + "~");
    }
}
