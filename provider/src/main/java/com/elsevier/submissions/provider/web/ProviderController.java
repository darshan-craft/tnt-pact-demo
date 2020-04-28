package com.elsevier.submissions.provider.web;

import com.elsevier.submissions.provider.entity.Message;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/welcome")
public class ProviderController {
    
    private static final Logger LOG = getLogger(ProviderController.class);
    
    @GetMapping(value = "{name}")
    public ResponseEntity<Message> welcomeMessage(@PathVariable String name) {
        final String msg = "Welcome to " + name + " !";
        LOG.info("Returning Message: {}", msg);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Message.builder().message(msg).build());
    }
}
