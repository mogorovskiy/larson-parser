package org.mogorovskiy.parser.larson;

import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.ProfileSourceScraper;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import static org.mogorovskiy.util.JsoupUtil.pageCompletelyLoaded;

@Component
public class LarsonProfileSourceScraper implements ProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String url, WebDriver webDriver) {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();

        webDriver.get(url);
        pageCompletelyLoaded(webDriver);

        String pageSource = webDriver.getPageSource();
        attorneyProfileSource.setSource(pageSource);
        attorneyProfileSource.setProfileUrl(url);

        return attorneyProfileSource;
    }
}
