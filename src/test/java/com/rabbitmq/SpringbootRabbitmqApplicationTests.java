package com.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRabbitmqApplicationTests.class);

	@Test
	void contextLoads() {
		LOGGER.info("Test case executing--------------------with test case new build");
		LOGGER.info("Build pipe line included-----------------");
		assertEquals(true, true);
		r
	}

}
