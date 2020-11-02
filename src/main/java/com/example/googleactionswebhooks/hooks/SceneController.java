package com.example.googleactionswebhooks.hooks;

import com.example.googleactionswebhooks.hook.google.api.generic.*;
import com.example.googleactionswebhooks.hook.google.api.request.GARequest;
import com.example.googleactionswebhooks.hook.google.api.response.GAResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/scene")
@Slf4j
@RestController
public class SceneController {

    @PostMapping("/toiletstr")
    public String nextSceneStr(@RequestBody GARequest request) throws JsonProcessingException {
        log.info("Next scene BEGIN");
        log.info("Request: " + request);
        return new ObjectMapper().writeValueAsString(nextScene(request));
    }
    @RequestMapping("/toilet")
    public GAResponse nextScene(@RequestBody GARequest request){
        log.info("Next scene BEGIN");
        log.info("Request: " + request);

        GAResponse response = new GAResponse(
                new GAPrompt(false,
                        new GAFirstSimple("This text comes from the server! Muahhahaha",null),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null),
                new GAScene("PlayGames",null,null, new GANextScene("Toilet")),
                request.getSession(), request.getUser(), request.getHome(),
                request.getDevice(), new GAExpected(null, null));

        log.info("Next scene END Response: "+ response);
        return response;
    }
}
