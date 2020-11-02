package com.example.googleactionswebhooks.hooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/ping")
public class PingRestController {
    @GetMapping("/")
    public String ping(){
        return "ponnnngg... " + LocalDateTime.now();
    }
}
