package org.mogorovskiy.parser.impl;

import org.mogorovskiy.parser.ProfileUrlsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileUrlsScraperImpl implements ProfileUrlsScraper {

    private static final String URL = "https://www.larsonllp.com/people/";

    @Override
    public List<String> scrape() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/mogorovskiy/selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        List<WebElement> attorneyProfileUrls = driver.findElements(By.cssSelector("div.people-intro a"));

        List<String> urls = attorneyProfileUrls.stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toList());
        driver.quit();

        return urls;
    }
}
