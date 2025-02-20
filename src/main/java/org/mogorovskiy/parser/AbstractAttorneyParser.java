package org.mogorovskiy.parser;

import lombok.RequiredArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.service.AttorneyService;
import org.mogorovskiy.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public abstract class AbstractAttorneyParser {

    private final ProfileParser profileParser;
    private final AttorneyService attorneyService;
    private final ProfileUrlsScraper profileUrlsScraper;
    private final ProfileSourceScraper profileSourceScraper;

    public void parse() throws IOException {
        WebDriver webDriver = WebDriverUtil.getWebDriver();
        List<String> profileUrls = profileUrlsScraper.scrape(webDriver);

        List<AttorneyProfileSource> profileSources = new ArrayList<>();
        for (String profileUrl : profileUrls) {
            profileSources.add(profileSourceScraper.scrape(profileUrl, webDriver));
        }

        List<Attorney> attorneys = new ArrayList<>();
        for (AttorneyProfileSource source : profileSources) {
            attorneys.add(profileParser.parse(source));
        }

        attorneyService.save(attorneys);
    }
}
