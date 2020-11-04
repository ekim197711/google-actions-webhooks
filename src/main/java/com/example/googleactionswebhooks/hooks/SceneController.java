package com.example.googleactionswebhooks.hooks;

import com.example.googleactionswebhooks.hook.google.api.generic.*;
import com.example.googleactionswebhooks.hook.google.api.request.GARequest;
import com.example.googleactionswebhooks.hook.google.api.response.GAResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/scene")
@Slf4j
@RestController
public class SceneController {

    @RequestMapping(path="/", method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GAResponse nextScene(@RequestBody GARequest request){
        log.info("Next scene BEGIN");
        log.info("Request: " + request);

        GAResponse response = new GAResponse(
                new GAPrompt(false,
                        new GAFirstSimple("This text comes from the server! You slay the monster.",null),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null),
                new GAScene(null,null,null, new GANextScene("YOU_WIN")),
                request.getSession(), request.getUser(), request.getHome(),
                request.getDevice(), new GAExpected(null, null));

        log.info("Next scene END Response: "+ response);
        return response;
    }
}


