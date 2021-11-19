package com.demo.SpringJmsProducer.publisher;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jms")
public class Producer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("message")
	private Queue messageQueue;

	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable final String message) {
		jmsTemplate.convertAndSend(messageQueue, message);
		return "Message published";
	}

}
