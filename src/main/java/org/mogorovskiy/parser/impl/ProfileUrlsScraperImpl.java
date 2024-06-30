package org.mogorovskiy.parser.impl;

import org.mogorovskiy.parser.ProfileUrlsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileUrlsScraperImpl implements ProfileUrlsScraper {

    private static final String URL = "https://www.larsonllp.com/people/";

    @Override
    public List<String> scrape(WebDriver webDriver) {
        webDriver.get(URL);

        List<WebElement> attorneyProfileUrls = webDriver.findElements(By.cssSelector("div.people-intro a"));

        List<String> urls = attorneyProfileUrls.stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toList());

        return urls;
    }
}
