package com.example.googleactionswebhooks.hook.service.pulje;

import dk.danskespil.voice.voicewebhookapp.feedapi.pulje.FAPuljeGameType;
import dk.danskespil.voice.voicewebhookapp.feedapi.pulje.FAPuljeResponse;
import dk.danskespil.voice.voicewebhookapp.feedapi.pulje.FAPuljeService;
import dk.danskespil.voice.voicewebhookapp.hook.google.api.request.GARequest;
import dk.danskespil.voice.voicewebhookapp.hook.google.api.response.GAResponse;
import dk.danskespil.voice.voicewebhookapp.hook.service.CreateResponseHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/pool")
public class PuljeHookController {
    private final FAPuljeService faPuljeService;

    @PostMapping("/")
    public GAResponse pulje(GARequest request){
        log.info("Pulje hook: Request: " + request);
        List<FAPuljeResponse> pulje = faPuljeService.pulje();
        String txt = "";
        for (FAPuljeResponse puljeItem : pulje) {
            if (puljeItem.gameType() == FAPuljeGameType.UNKNOWN)
                continue;
            txt += puljeItem.gameType().getSpeach() + " " + puljeItem.getPoolSize() + ". ";
        }
        GAResponse simpleResponse = new CreateResponseHelper().createSimpleResponse(txt, "");
        log.info("Pulje hook: Response: " + simpleResponse);
        return simpleResponse;
    }
}
