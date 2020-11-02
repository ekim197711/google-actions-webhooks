package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAFirstSimple {
    private String speech;
    private String text;
}
