package org.mogorovskiy.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;

public class ProfileParserImpl implements ProfileParser {

    @Override
    public Attorney parse(AttorneyProfileSource attorneySource) {
        Document attorneyPage = Jsoup.parse(attorneySource.getSource());

        Attorney attorney = new Attorney();
        attorney.setProfileUrl(attorneySource.getProfileUrl());
        attorney.setBio();
        attorney.setEmails();
        attorney.setPhones();
        attorney.setLocations();
        attorney.setLinkedinUrl();
        attorney.setFullName();
        attorney.setPracticeAreas();
        attorney.setSpecialties();
        attorney.setTitle();
        attorney.setPhotoUrl();

        return attorney;
    }
}
