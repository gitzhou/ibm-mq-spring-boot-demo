package com.ibm.mq.spring.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author bjzquan
 */
@Component
public class AnotherReceiver {

    @JmsListener(destination = "DEV.QUEUE.2")
    public void receiveMessage(String message) {
        System.out.println("DEV.QUEUE.2 received ~" + message + "~");
    }
}
