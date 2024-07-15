package org.mogorovskiy.util;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

import static org.mogorovskiy.parser.larson.LarsonProfileParser.PRACTICE_AREAS_SELECTOR;

public class ParsePracticeAreas {
    public static List<String> parsePracticeAreas(Document attorneyPage) {
        Elements practiceAreasElements = attorneyPage.select(PRACTICE_AREAS_SELECTOR);
        return practiceAreasElements.eachText().stream()
                .map(text -> TextTrimmer.trimText(text, 3))
                .collect(Collectors.toList());
    }
}
