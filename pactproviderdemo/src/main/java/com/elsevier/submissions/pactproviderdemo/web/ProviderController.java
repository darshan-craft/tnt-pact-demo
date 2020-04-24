package com.elsevier.submissions.pactproviderdemo.web;

import com.elsevier.submissions.dto.MessageDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class ProviderController {

    @GetMapping(value = "{name}")
    public MessageDto welcomeMessage(@PathVariable String name) {

        MessageDto msg = new MessageDto();
        msg.setMessage("Welcome to " + name + " !");
        return msg;
    }
}
