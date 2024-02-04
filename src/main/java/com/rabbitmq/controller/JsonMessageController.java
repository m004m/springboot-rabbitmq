package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.dto.User;
import com.rabbitmq.publiser.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/jsonmessage")
public class JsonMessageController {
	
	
	@Autowired
	private RabbitMQJsonProducer rabbitMQJsonProducer; 
	
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user){
		rabbitMQJsonProducer.sendJsonMessageToQueue(user);
		return ResponseEntity.ok("Json Message sent to RabbitMQ");
	}

}
