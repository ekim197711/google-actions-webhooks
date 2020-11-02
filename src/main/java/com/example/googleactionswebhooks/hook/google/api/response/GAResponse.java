package com.example.googleactionswebhooks.hook.google.api.response;

import com.example.googleactionswebhooks.hook.google.api.generic.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAResponse {
    GAPrompt prompt;
    GAScene scene;
    GASession session;
    GAUser user;
    GAHome home;
    GADevice device;
    GAExpected expected;
}
