package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GAScene {
    private String name;
    private String slotFillingStatus;
    private HashMap<String, Object> slots;
    private GANextScene next;
}
