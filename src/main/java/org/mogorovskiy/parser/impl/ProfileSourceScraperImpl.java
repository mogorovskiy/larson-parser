package org.mogorovskiy.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfileSourceScraperImpl implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url, WebDriver webDriver) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        Wait<WebDriver> wait = new WebDriverWait(webDriver, 5).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main")));

        Document doc = Jsoup.connect(url).get();
        attorneyProfileSource.setSource(doc.toString());
        attorneyProfileSource.setProfileUrl(url);

        return attorneyProfileSource;
    }
}
