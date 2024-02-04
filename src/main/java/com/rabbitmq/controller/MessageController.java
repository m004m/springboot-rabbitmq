package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.publiser.RabbitMQProducer;

@RestController
@RequestMapping("/api/message")
public class MessageController {
	
	@Autowired
	private RabbitMQProducer rabbitMQProducer; 
	
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		rabbitMQProducer.sendMessageToQueue(message);
		return ResponseEntity.ok("Message sent to RabbitMQ");
	}

}
