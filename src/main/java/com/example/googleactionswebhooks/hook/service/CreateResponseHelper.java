package com.example.googleactionswebhooks.hook.service;

import com.example.googleactionswebhooks.hook.google.api.generic.*;
import com.example.googleactionswebhooks.hook.google.api.response.GAResponse;

import java.util.HashMap;
import java.util.List;

public class CreateResponseHelper {

    public GAResponse createSimpleResponse(String responseText, String nextScene){
        GAResponse resp = new GAResponse(
            new GAPrompt(false,
                    new GAFirstSimple(responseText, ""),
                    null,
                    null,
                    List.of(new GASuggestion("Seneste lotto numre"),
                            new GASuggestion("Puljen"),
                            new GASuggestion("Hjælp")
                            ),null,null,null
            ),
            new GAScene("LottoNumbersScene",null, new HashMap<>(),
                    new GANextScene(nextScene)),
            new GASession("example_session_id",
                    new HashMap<>(),null),
            null, null, null, null);

            return resp;
    }
}
