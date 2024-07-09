package org.mogorovskiy.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;
import org.springframework.stereotype.Component;

import static org.mogorovskiy.helper.JsoupHelper.toStringList;
import static org.mogorovskiy.util.ParseProfilePhotoUrl.parseProfilePhotoUrl;

@Component
public class ProfileParserImpl implements ProfileParser {

    public static final String BIO_SELECTOR = "#tabpanel-0 > p:nth-child(2)";
    public static final String EMAIL_SELECTOR = ".aboveline a";
    public static final String LOCATIONS_SELECTOR = "div.columns-3 > div:nth-child(4)";
    public static final String FULL_NAME_SELECTOR = ".bio-name > h1";
    public static final String PRACTICE_AREAS_SELECTOR = ".columns-8.areas > ul";
    public static final String TITLE_SELECTOR = ".has-herotext-font-size";


    @Override
    public Attorney parse(AttorneyProfileSource attorneySource) {
        Document attorneyPage = Jsoup.parse(attorneySource.getSource());
        Attorney attorney = new Attorney();

        attorney.setProfileUrl(attorneySource.getProfileUrl());
        attorney.setBio(attorneyPage.select(BIO_SELECTOR).text());
        attorney.setEmail(attorneyPage.select(EMAIL_SELECTOR).text());
        attorney.setPhone(attorneyPage.select(".label:first-child").text()); //TODO: лищняя инфа
        attorney.setLocations(toStringList(attorneyPage.select(LOCATIONS_SELECTOR)));
        attorney.setLinkedinUrl(attorneyPage.select(".social li").text()); //TODO: WTF?
        attorney.setFullName(attorneyPage.select(FULL_NAME_SELECTOR).text());
        attorney.setPracticeAreas(toStringList(attorneyPage.select(PRACTICE_AREAS_SELECTOR)));
        attorney.setTitle(attorneyPage.select(TITLE_SELECTOR).text());
        attorney.setPhotoUrl(parseProfilePhotoUrl(attorneyPage));

        return attorney;
    }
}
