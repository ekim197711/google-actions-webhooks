package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Union field content can be only one of the following:
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAContent {
    private GAContentCard card;
    private GAImage image;
    private GATable table;
    private GAMedia media;
    private GACollection collection;
    private GAList list;
}
// End of list of possible types for union field content.
