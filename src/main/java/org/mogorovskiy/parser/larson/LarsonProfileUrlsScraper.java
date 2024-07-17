package org.mogorovskiy.parser.larson;

import org.mogorovskiy.parser.ProfileUrlsScraper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mogorovskiy.util.JsoupUtil.pageCompletelyLoaded;

@Component
public class LarsonProfileUrlsScraper implements ProfileUrlsScraper {

    private static final String PROFILE_URLS_SELECTOR = "div.people-intro a";
    private static final String URL = "https://www.larsonllp.com/people/";

    @Override
    public List<String> scrape(WebDriver webDriver) {
        webDriver.get(URL);
        pageCompletelyLoaded(webDriver);

        List<WebElement> attorneyProfileUrls = webDriver.findElements(By.cssSelector(PROFILE_URLS_SELECTOR));

        return attorneyProfileUrls.stream()
                .map(element -> element.getAttribute("href"))
                .collect(toList());
    }
}
