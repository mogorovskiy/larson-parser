package org.mogorovskiy.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseLinkedInUrl {
    public static String parseLinkedInUrl(Document attorneyPage) {
        Elements elements = attorneyPage.select("a[href*='linkedin.com/in']");
        if (elements.isEmpty()) {
            return null;
        }

        Element linkedInElement = elements.first();
        return linkedInElement.attr("href");
    }
}
