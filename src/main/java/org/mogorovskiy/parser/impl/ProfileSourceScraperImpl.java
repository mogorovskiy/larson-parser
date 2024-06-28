package org.mogorovskiy.parser.impl;

import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProfileSourceScraperImpl implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url) {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        attorneyProfileSource.setSource(webDriver.getPageSource());
        attorneyProfileSource.setProfileUrl(url);

        System.out.println(attorneyProfileSource);

        return attorneyProfileSource;
    }
}
