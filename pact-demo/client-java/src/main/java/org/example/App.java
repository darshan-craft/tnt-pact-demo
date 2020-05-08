package org.example;

import org.example.client.PactDemoClient;
import org.example.entity.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Hello world!
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    
    private static final Logger LOG = getLogger(App.class);
    
    @Autowired
    private PactDemoClient pactDemoClient;
    
    public static void main(String[] args) {
        
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
        
    }
    
    @Override
    public void run(String... args) {
        
        Message msg = pactDemoClient.getWelcomeMsg("The Jungle");
        LOG.info("########### {} ###########", msg);
    }
}
