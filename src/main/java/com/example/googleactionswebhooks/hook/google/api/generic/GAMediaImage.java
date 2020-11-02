package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAMediaImage {
    private GAImage large;
    private GAImage icon;
}
