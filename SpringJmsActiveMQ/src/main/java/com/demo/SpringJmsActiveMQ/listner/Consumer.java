package com.demo.SpringJmsActiveMQ.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.demo.SpringJmsActiveMQ.model.Item;

@Component
public class Consumer {

	Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "message.queue")
	public void messageistener(String message) {
		logger.info("From message.queue : " + message);

	}

	@JmsListener(destination = "item.queue")
	public void itemListener(Item item) {
		logger.info("From item.queue : " + item);

	}
}
