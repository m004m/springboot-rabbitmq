package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;

@Service
public class RabbitMQJsonConsumer {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
//	@RabbitListener(queues = {"${rabbitmq.jsonqueue.name}"})  //consume message from the passed queue as name
//	public void consumeMessageFromJsonQueue(User user) {
//		LOGGER.info(String.format("Json Message Received -> %s", user.toString()));
//	}
	
}
