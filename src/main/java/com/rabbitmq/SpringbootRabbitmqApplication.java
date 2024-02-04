package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootRabbitmqApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRabbitmqApplication.class);
	
	@PostConstruct
	public void init() {
		LOGGER.info("Application started ----------------");
	}

	public static void main(String[] args) {
		LOGGER.info("Application executed ----------------");
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}

}
