package org.mogorovskiy.parser.larson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;

import static org.mogorovskiy.util.JsoupUtil.parseLinkedInUrl;
import static org.mogorovskiy.util.JsoupUtil.parseLocations;
import static org.mogorovskiy.util.JsoupUtil.parsePhoneNumber;
import static org.mogorovskiy.util.JsoupUtil.parseProfilePhotoUrl;

public class LarsonProfileParser implements ProfileParser {

    public static final String BIO_SELECTOR = ".biography.content p";
    public static final String EMAIL_SELECTOR = ".aboveline a";
    public static final String LOCATIONS_SELECTOR = "#offices";
    public static final String FULL_NAME_SELECTOR = ".bio-name > h1";
    public static final String PRACTICE_AREAS_SELECTOR = ".columns-8.areas > ul > li";
    public static final String TITLE_SELECTOR = ".columns-4.bio-name h2";

    @Override
    public Attorney parse(AttorneyProfileSource attorneySource) {
        Document attorneyPage = Jsoup.parse(attorneySource.getSource());
        Attorney attorney = new Attorney();

        attorney.setProfileUrl(attorneySource.getProfileUrl());
        attorney.setBio(attorneyPage.select(BIO_SELECTOR).text());
        attorney.setEmail(attorneyPage.select(EMAIL_SELECTOR).text());
        attorney.setPhone(parsePhoneNumber(attorneyPage));
        attorney.setLocations(parseLocations(attorneyPage));
        attorney.setLinkedinUrl(parseLinkedInUrl(attorneyPage));
        attorney.setFullName(attorneyPage.select(FULL_NAME_SELECTOR).text());
        attorney.setPracticeAreas(attorneyPage.select(PRACTICE_AREAS_SELECTOR).eachText());
        attorney.setTitle(attorneyPage.select(TITLE_SELECTOR).text());
        attorney.setPhotoUrl(parseProfilePhotoUrl(attorneyPage));

        return attorney;
    }
}
