package org.example;

import org.example.client.PactDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    private PactDemoClient pactDemoClient;

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .<String, Object>singletonMap("server.port", "8083"));
        app.run(args);
        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) {
        String msg = pactDemoClient.getWelcomeMsg("The Jungle");
        System.out.println("########### " + msg + " ###########");
    }
}
