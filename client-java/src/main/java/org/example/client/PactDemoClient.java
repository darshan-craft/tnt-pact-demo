package org.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class PactDemoClient {

    private final String url;
  
    private RestOperations restOps;

    @Autowired
    public PactDemoClient(@Value("${pactdemo.service.url}") final String url) {

        this.url = url;
    }

    public String getWelcomeMsg(final String name) {
        restOps = new RestTemplate() ;
        return restOps.getForObject(url, String.class, name);
    }
}
