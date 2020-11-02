package com.example.googleactionswebhooks.hook.google.api.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A card for presenting a collection of options to select from.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GACollection {
    /**
     * Title of the collection. Optional.
     */
    private String title;
    /**
     * Subtitle of the collection. Optional.
     */
    private String subtitle;
    /**
     * min: 2 max: 10
     */
    private List<GAContentCollectionItem> items;
    /**
     * How the image backgrounds of collection items will be filled. Optional.
     */
    private GAImageFill imageFill;
}
