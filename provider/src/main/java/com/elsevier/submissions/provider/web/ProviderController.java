package com.elsevier.submissions.provider.web;

import com.elsevier.submissions.provider.entity.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class ProviderController {

    @GetMapping(value = "{name}")
    public Message welcomeMessage(@PathVariable String name) {
    
        return Message.builder()
                .message("Welcome to " + name + " !")
                .build();
    }
}
