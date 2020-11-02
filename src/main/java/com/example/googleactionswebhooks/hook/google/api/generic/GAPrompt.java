package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAPrompt {
    private Boolean override;
    private GAFirstSimple firstSimple;
    private GAContent content;
    private GAFirstSimple lastSimple;
    private List<GASuggestion> suggestions;
    private GALink link;
    private GACanvas canvas;
    private GAOrderUpdate orderUpdate;
}
