package com.rabbitmq.publiser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;

@Service
public class RabbitMQJsonProducer {
	


	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	
	
	@Value("${rabbitmq.jsonRouting.key}")
	private String jsonRoutingKey;
	
	//rabbit template to send the message from spring 
	private RabbitTemplate rabbitTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

	// rabbit template bean get using constructor based injection
	//@Autowired
	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	//send message using the rabbit-mq template
	public void sendJsonMessageToQueue(User user) {
		LOGGER.info(String.format("Json Message sent -> %s", user.toString()));
		
		rabbitTemplate.convertAndSend(exchangeName,jsonRoutingKey,user);
	}
	


}
