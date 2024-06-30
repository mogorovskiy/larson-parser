package org.mogorovskiy.parser.impl;

import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.WebDriver;

public class ProfileSourceScraperImpl implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url, WebDriver webDriver) {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        attorneyProfileSource.setSource(webDriver.getPageSource());
        attorneyProfileSource.setProfileUrl(url);

        return attorneyProfileSource;
    }
}
