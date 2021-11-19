package com.demo.SpringJmsActiveMQ.publisher;

import java.util.Random;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringJmsActiveMQ.model.Item;

@RestController
@RequestMapping("/jms")
public class Producer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("message")
	private Queue messageQueue;

	@Autowired
	@Qualifier("item")
	private Queue itemQueue;

	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable final String message) {
		jmsTemplate.convertAndSend(messageQueue, message);
		return "Message published";
	}

	@GetMapping("/publishItem")
	public String publishItem() {
		Random r = new Random();
		Item item = new Item(r.nextInt(), "name" + r.hashCode());
		jmsTemplate.convertAndSend(itemQueue, item);
		return "Item published";
	}

}
