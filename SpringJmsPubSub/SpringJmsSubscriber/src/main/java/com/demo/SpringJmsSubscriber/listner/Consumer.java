package com.demo.SpringJmsSubscriber.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "notice.topic")
	public void messageSubscriber1(String message) {
		logger.info("Subscriber 1 received from notice.topic : " + message);

	}

	@JmsListener(destination = "notice.topic")
	public void messageSubscriber2(String message) {
		logger.info("Subscriber 2 received from notice.topic : " + message);

	}

	@JmsListener(destination = "notice.topic")
	public void messageSubscriber3(String message) {
		logger.info("Subscriber 3 received from notice.topic : " + message);

	}

}
