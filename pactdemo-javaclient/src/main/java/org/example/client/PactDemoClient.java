package org.example.client;

import com.elsevier.submissions.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class PactDemoClient {

    private final String url;
    @Autowired
    private RestOperations restOps;

    @Autowired
    public PactDemoClient(@Value("${pactdemo.service.url}") final String url) {
        this.url = url;
    }

    public MessageDto getWelcomeMsg(final String name) {
        MessageDto dto = restOps.getForObject(url, MessageDto.class, name);
        return dto;
    }
}
