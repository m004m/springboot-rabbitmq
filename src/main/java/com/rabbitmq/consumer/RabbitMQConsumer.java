package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
	
	@Value("${rabbitmq.queue.name}")
	private String queueName;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	
//	@RabbitListener(queues = {"${rabbitmq.queue.name}"})  //consume message from the passed queue as name
//	public void consumeMessageFromQueue(String message) {
//		LOGGER.info(String.format("Message Received -> %s", message));
//	}

}
