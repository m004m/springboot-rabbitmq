package com.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queueName;
	
	@Value("${rabbitmq.jsonqueue.name}")
	private String jsonQueueName;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchangeName;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.jsonRouting.key}")
	private String jsonRoutingKey;
	
	
	//spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
	
	//bean for json object
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueueName);
	}
	
	
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}
	
	
	//bind queue and exchage using the routing key
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue())
				.to(exchange())
				.with(routingKey);
				
	}
	
	//bind json-queue and exchage using the routing key
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue())
				.to(exchange())
				.with(jsonRoutingKey);
				
	}
	 
	//below beans auto configure spring provide for us
	//connection factory
	//rabbit template
	//rabbitAdmin 
	
	@Bean
	public MessageConverter convertMessage() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		
		RabbitTemplate rabbitTemplate = new  RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(convertMessage());
		return rabbitTemplate;
		
	}

}
