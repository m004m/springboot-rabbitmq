package com.rabbitmq.publiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.jsonRouting.key}")
	private String jsonRoutingKey;
	
	//rabbit template to send the message from spring 
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

	// rabbit template bean get using constructor based injection
	//@Autowired
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	//send message using the rabbit-mq template
	public void sendMessageToQueue(String message) {
		LOGGER.info(String.format("Message sent -> %s", message));
		
		rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
	}
	
}
