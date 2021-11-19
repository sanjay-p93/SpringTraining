package com.demo.SpringJmsPublisher.publisher;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
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
	private Topic topic;

	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable final String message) {
		jmsTemplate.convertAndSend(topic, message);
		return "Message published";
	}

}
