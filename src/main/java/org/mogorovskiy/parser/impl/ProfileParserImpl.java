package org.mogorovskiy.parser.impl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;
import org.springframework.stereotype.Component;

import static org.mogorovskiy.helper.JsoupHelper.toStringList;

@Component
public class ProfileParserImpl implements ProfileParser {

    public static final String SET_BIO_SELECTOR = "#tabpanel-0 > p:nth-child(2)";
    public static final String SET_EMAIL_SELECTOR = ".aboveline a";
    public static final String SET_LOCATIONS_SELECTOR = "div.columns-3 > div:nth-child(4)";
    public static final String SET_FULL_NAME_SELECTOR = ".bio-name > h1";
    public static final String SET_PRACTICE_AREAS_SELECTOR = ".columns-8.areas > ul";
    public static final String SET_TITLE_SELECTOR = ".has-herotext-font-size";

    @Override
    public Attorney parse(AttorneyProfileSource attorneySource) {
        Document attorneyPage = Jsoup.parse(attorneySource.getSource());
        Attorney attorney = new Attorney();

        attorney.setProfileUrl(attorneySource.getProfileUrl());
        attorney.setBio(attorneyPage.select(SET_BIO_SELECTOR).text());
        attorney.setEmail(attorneyPage.select(SET_EMAIL_SELECTOR).text());
        attorney.setPhone(attorneyPage.select(".label:first-child").text()); //TODO: лищняя инфа
        attorney.setLocations(toStringList(attorneyPage.select(SET_LOCATIONS_SELECTOR)));
        attorney.setLinkedinUrl(attorneyPage.select(".social li").text()); //TODO: WTF?
        attorney.setFullName(attorneyPage.select(SET_FULL_NAME_SELECTOR).text());
        attorney.setPracticeAreas(toStringList(attorneyPage.select(SET_PRACTICE_AREAS_SELECTOR)));
        attorney.setTitle(attorneyPage.select(SET_TITLE_SELECTOR).text());
        attorney.setPhotoUrl(getPhotoUrl(attorneyPage));

        return attorney;
    }

    private String getPhotoUrl(Document attorneyPage) {
        Element element = attorneyPage.select(".row.flexbox.contact-block.wrap").first();
        if (element != null) {
            String styleAttribute = element.attr("style");
            String imageUrl = StringUtils.substringBetween(styleAttribute, "url('", "')");
            return imageUrl;
        }

        return null;
    }
}
