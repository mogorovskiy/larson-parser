package org.mogorovskiy.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParsePhoneNumber {

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
}
