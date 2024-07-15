package org.mogorovskiy.util;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

import static org.mogorovskiy.parser.larson.LarsonProfileParser.LOCATIONS_SELECTOR;

public class ParseLocations {
    public static List<String> parseLocations(Document attorneyPage) {
        Elements locationElements = attorneyPage.select(LOCATIONS_SELECTOR);
        return locationElements.eachText().stream()
                .map(text -> TextTrimmer.trimText(text, 3))
                .collect(Collectors.toList());
    }
}
