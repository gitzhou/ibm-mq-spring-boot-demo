package com.ibm.mq.spring.demo;


import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.mq.spring.boot.MQConfigurationProperties;
import com.ibm.mq.spring.boot.MQConnectionFactoryCustomizer;
import com.ibm.mq.spring.boot.MQConnectionFactoryFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.List;

public class JmsConfig {

    @Configuration
    @EnableJms
    static class MQ1Config{

        @Value("${mq1.mq-info.queue-manager}")
        private String qm;
        @Value("${mq1.mq-info.channel}")
        private String channel;
        @Value("${mq1.mq-info.conn-name}")
        private String connName;
        @Value("${mq1.mq-info.user}")
        private String user;
        @Value("${mq1.mq-info.password}")
        private String password;

        @Bean("mq1ListenerContainerFactory")
        public DefaultJmsListenerContainerFactory mq1ListenerContainerFactory(@Qualifier("mq1ConnectionFactory") ConnectionFactory mq1ConnectionFactory) {
            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(mq1ConnectionFactory);
            return factory;
        }

        @Bean("mq1ConnectionFactory")
        public ConnectionFactory mq1ConnectionFactory(@Qualifier("mq1ConfigurationProperties") MQConfigurationProperties mq1ConfigurationProperties,
                                                      ObjectProvider<List<MQConnectionFactoryCustomizer>> factoryCustomizers){
            return new MQConnectionFactoryFactory(mq1ConfigurationProperties, factoryCustomizers.getIfAvailable()).createConnectionFactory(MQConnectionFactory.class);
        }

        @Bean("mq1ConfigurationProperties")
        public MQConfigurationProperties mq1ConfigurationProperties(){
            MQConfigurationProperties mqConfigurationProperties = new MQConfigurationProperties();
            mqConfigurationProperties.setQueueManager(qm);
            mqConfigurationProperties.setChannel(channel);
            mqConfigurationProperties.setConnName(connName);
            mqConfigurationProperties.setUser(user);
            mqConfigurationProperties.setPassword(password);
            return mqConfigurationProperties;
        }

        @Bean("jmsTemplate1")
        public JmsTemplate jmsTemplate1(@Qualifier("mq1ConnectionFactory") ConnectionFactory mq1ConnectionFactory) {
            JmsTemplate jmsTemplate = new JmsTemplate();
            jmsTemplate.setConnectionFactory(mq1ConnectionFactory);
            return jmsTemplate;
        }

    }

    @Configuration
    @EnableJms
    static class MQ2Config{

        @Value("${mq2.mq-info.queue-manager}")
        private String qm;
        @Value("${mq2.mq-info.channel}")
        private String channel;
        @Value("${mq2.mq-info.conn-name}")
        private String connName;
        @Value("${mq2.mq-info.user}")
        private String user;
        @Value("${mq2.mq-info.password}")
        private String password;

        @Bean("mq2ListenerContainerFactory")
        public DefaultJmsListenerContainerFactory mq2ListenerContainerFactory(@Qualifier("mq2ConnectionFactory") ConnectionFactory mq2ConnectionFactory) {
            DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(mq2ConnectionFactory);
            return factory;
        }

        @Bean("mq2ConnectionFactory")
        public ConnectionFactory mq2ConnectionFactory(@Qualifier("mq2ConfigurationProperties") MQConfigurationProperties mq2ConfigurationProperties,
                                                      ObjectProvider<List<MQConnectionFactoryCustomizer>> factoryCustomizers){
            return new MQConnectionFactoryFactory(mq2ConfigurationProperties, factoryCustomizers.getIfAvailable()).createConnectionFactory(MQConnectionFactory.class);
        }

        @Bean("mq2ConfigurationProperties")
        public MQConfigurationProperties mq2ConfigurationProperties(){
            MQConfigurationProperties mqConfigurationProperties = new MQConfigurationProperties();
            mqConfigurationProperties.setQueueManager(qm);
            mqConfigurationProperties.setChannel(channel);
            mqConfigurationProperties.setConnName(connName);
            mqConfigurationProperties.setUser(user);
            mqConfigurationProperties.setPassword(password);
            return mqConfigurationProperties;
        }

        @Bean("jmsTemplate2")
        public JmsTemplate jmsTemplate2(@Qualifier("mq2ConnectionFactory") ConnectionFactory mq2ConnectionFactory) {
            JmsTemplate jmsTemplate = new JmsTemplate();
            jmsTemplate.setConnectionFactory(mq2ConnectionFactory);
            return jmsTemplate;
        }

    }

}
