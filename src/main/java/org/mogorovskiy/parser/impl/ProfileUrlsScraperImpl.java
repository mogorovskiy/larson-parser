package org.mogorovskiy.parser.impl;

import org.mogorovskiy.parser.ProfileUrlsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProfileUrlsScraperImpl implements ProfileUrlsScraper {

    public static final String PROFILE_URLS_SEELCTOR = "div.people-intro a";
    private static final String URL = "https://www.larsonllp.com/people/";

    @Override
    public List<String> scrape(WebDriver webDriver) {
        webDriver.get(URL);

        List<WebElement> attorneyProfileUrls = webDriver.findElements(By.cssSelector(PROFILE_URLS_SEELCTOR));

        List<String> urls = attorneyProfileUrls.stream()
                .map(element -> element.getAttribute("href"))
                .collect(toList());

        return urls;
    }
}
