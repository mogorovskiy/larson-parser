package org.mogorovskiy.parser.impl;

import org.jsoup.Jsoup;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProfileSourceScraperImpl implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url, WebDriver webDriver) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        attorneyProfileSource.setSource(Jsoup.connect(url).get().toString());
        attorneyProfileSource.setProfileUrl(url);

        return attorneyProfileSource;
    }
}
