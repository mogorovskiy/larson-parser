package org.mogorovskiy.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.mogorovskiy.parser.larson.LarsonProfileParser.LOCATIONS_SELECTOR;
import static org.mogorovskiy.parser.larson.LarsonProfileParser.PRACTICE_AREAS_SELECTOR;

public class JsoupUtil {

    public static void pageCompletelyLoaded(WebDriver driver) {
        new WebDriverWait(driver, 30).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static String parseLinkedInUrl(Document attorneyPage) {
        Elements elements = attorneyPage.select("a[href*='linkedin.com/in']");
        if (elements.isEmpty()) {
            return null;
        }

        Element linkedInElement = elements.first();
        return linkedInElement.attr("href");
    }

    public static String trimText(String text, int sentenceCount) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] sentences = text.split("\\.\\s*");
        StringBuilder trimmedText = new StringBuilder();

        for (int i = 0; i < Math.min(sentenceCount, sentences.length); i++) {
            String sentenceToAdd = sentences[i] + ". ";
            if (trimmedText.length() + sentenceToAdd.length() <= 255) {
                trimmedText.append(sentenceToAdd);
            } else {
                break;
            }
        }

        return trimmedText.toString().trim();
    }

    public static List<String> parseLocations(Document attorneyPage) {
        Elements locationElements = attorneyPage.select(LOCATIONS_SELECTOR);
        return locationElements.eachText().stream()
                .map(text -> trimText(text, 3))
                .collect(Collectors.toList());
    }

    public static String parsePhoneNumber(Document attorneyPage) {
        Element abovelineElement = attorneyPage.select(".aboveline").first();
        if (abovelineElement == null) {
            return null;
        }

        String[] parts = abovelineElement.html().split("<br>");
        for (String part : parts) {
            Element partElement = Jsoup.parse(part).body();
            Element telElement = partElement.select("h3:contains(TEL)").first();
            if (telElement != null) {
                return partElement.ownText().trim();
            }
        }

        return null;
    }

    public static List<String> parsePracticeAreas(Document attorneyPage) {
        Elements practiceAreasElements = attorneyPage.select(PRACTICE_AREAS_SELECTOR);
        return practiceAreasElements.eachText().stream()
                .map(text -> trimText(text, 3))
                .collect(Collectors.toList());
    }

    public static String parseProfilePhotoUrl(Document attorneyPage) {
        Element element = attorneyPage.select(".row.flexbox.contact-block.wrap").first();
        if (element == null) {
            return null;
        }

        return substringBetween(element.attr("style"), "url('", "')");
    }
}
