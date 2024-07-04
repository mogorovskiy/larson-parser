package org.mogorovskiy.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileParser;

import static org.mogorovskiy.helper.JsoupHelper.toStringList;

public class ProfileParserImpl implements ProfileParser {

    @Override
    public Attorney parse(AttorneyProfileSource attorneySource) {
        Document attorneyPage = Jsoup.parse(attorneySource.getSource());
        Attorney attorney = new Attorney();

        attorney.setProfileUrl(attorneySource.getProfileUrl());
        attorney.setBio(attorneyPage.select(".has-herotext-font-size").text()); //TODO: лищняя инфа
        attorney.setEmail(attorneyPage.select(".aboveline a").text()); //OK
        attorney.setPhone(attorneyPage.select("#contact-block > div > div:nth-child(3) > div:nth-child(1)").text()); //TODO: лищняя инфа
        attorney.setLocations(toStringList(attorneyPage.select("div.columns-3 > div:nth-child(4)")));   //OK
        attorney.setLinkedinUrl(attorneyPage.select(".bio-contact > ul > li").text()); //TODO: WTF?
        attorney.setFullName(attorneyPage.select(".bio-name > h1").text()); //OK
        attorney.setPracticeAreas(toStringList(attorneyPage.select(".columns-8.areas > ul")));  //OK
        //attorney.setSpecialties();
        //attorney.setTitle();
        attorney.setPhotoUrl(attorneyPage.select("#contact-block > div").text());

        return attorney;
    }
}
