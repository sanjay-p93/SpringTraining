package com.demo.SpringJmsActiveMQ.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class QueueConfig {

	@Bean("message")
	public Queue getQueue() {
		return new ActiveMQQueue("message.queue");
	}

	@Bean("item")
	public Queue getQueue2() {
		return new ActiveMQQueue("item.queue");
	}

}
