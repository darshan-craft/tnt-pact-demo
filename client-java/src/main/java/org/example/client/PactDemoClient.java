package org.example.client;

import org.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class PactDemoClient {

    private final String url;
    
    @Autowired
    public PactDemoClient(@Value("${demo-provider.url:http://localhost:8080/welcome/{name}}") final String url) {

        this.url = url;
    }

    public Message getWelcomeMsg(final String name) {
    
        final RestOperations restOps = new RestTemplate();
        return restOps.getForObject(url, Message.class, name);
    }
}
