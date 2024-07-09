package org.mogorovskiy.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static org.apache.commons.lang3.StringUtils.substringBetween;

public class ParseProfilePhotoUrl {

    public static String parseProfilePhotoUrl(Document attorneyPage) {
        Element element = attorneyPage.select(".row.flexbox.contact-block.wrap").first();
        if (element == null) {
            return null;
        }

        return substringBetween(element.attr("style"), "url('", "')");
    }
}
