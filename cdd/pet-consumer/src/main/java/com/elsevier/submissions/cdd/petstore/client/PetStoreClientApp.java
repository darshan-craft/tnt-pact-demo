package com.elsevier.submissions.cdd.petstore.client;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication(scanBasePackages = {"com.elsevier.submissions.cdd.petstore"})
public class PetStoreClientApp implements CommandLineRunner {
    
    private static final Logger LOG = getLogger(PetStoreClientApp.class);
    
    public static void main(String[] args) {
        
        SpringApplication app = new SpringApplication(PetStoreClientApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
        
    }
    
    @Override
    public void run(String... args) {
        
        LOG.info("########### Connected to Pet Store! ###########");
    }
}
