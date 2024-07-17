package org.mogorovskiy.parser.larson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;

import static org.mogorovskiy.util.JsoupUtil.parseLinkedInUrl;
import static org.mogorovskiy.util.JsoupUtil.parseLocations;
import static org.mogorovskiy.util.JsoupUtil.parsePhoneNumber;
import static org.mogorovskiy.util.JsoupUtil.parsePracticeAreas;
import static org.mogorovskiy.util.JsoupUtil.parseProfilePhotoUrl;
import static org.mogorovskiy.util.JsoupUtil.trimText;

public class LarsonProfileParser implements ProfileParser {

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
        String bio = attorneyPage.select(BIO_SELECTOR).text();
        attorney.setBio(trimText(bio, 1));
        attorney.setEmail(attorneyPage.select(EMAIL_SELECTOR).text());
        attorney.setPhone(parsePhoneNumber(attorneyPage));
        attorney.setLocations(parseLocations(attorneyPage));
        attorney.setLinkedinUrl(parseLinkedInUrl(attorneyPage));
        attorney.setFullName(attorneyPage.select(FULL_NAME_SELECTOR).text());
        attorney.setPracticeAreas(parsePracticeAreas(attorneyPage));

        String title = attorneyPage.select(TITLE_SELECTOR).text();
        attorney.setTitle(trimText(title, 1));
        attorney.setPhotoUrl(parseProfilePhotoUrl(attorneyPage));

        return attorney;
    }
}
