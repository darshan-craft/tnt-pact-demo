package com.elsevier.submissions.cdd.petstore.server;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class PetServerApplication {
	
	private static final Logger LOG = getLogger(PetServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PetServerApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		LOG.info("hello world, I have just started up");
	}

}

