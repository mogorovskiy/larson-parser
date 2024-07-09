package org.mogorovskiy.parser.impl;

import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.mogorovskiy.util.PageCompletelyLoaded.pageCompletelyLoaded;

public class ProfileSourceScraperImpl implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url, WebDriver webDriver) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        webDriver.get(url);
        pageCompletelyLoaded(webDriver);

        String pageSource = webDriver.getPageSource();
        attorneyProfileSource.setSource(pageSource);
        attorneyProfileSource.setProfileUrl(url);

        return attorneyProfileSource;
    }
}
