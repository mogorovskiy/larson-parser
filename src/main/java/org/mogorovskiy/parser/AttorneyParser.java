package org.mogorovskiy.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.impl.ProfileParserImpl;
import org.mogorovskiy.parser.impl.ProfileSourceScraperImpl;
import org.mogorovskiy.parser.impl.ProfileUrlsScraperImpl;
import org.mogorovskiy.selenium.WebDriverUtil;
import org.mogorovskiy.service.AttorneyService;
import org.mogorovskiy.service.AttorneyServiceImpl;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class AttorneyParser {

    private ProfileUrlsScraper profileUrlsScraper;
    private ProfileSourceScraper profileSourceScraper;
    private ProfileParser profileParser;
    private AttorneyService attorneyService;
    private WebDriverUtil DRIVER_UTIL;

    public List<Attorney> parse() throws IOException {
        WebDriver webDriver = DRIVER_UTIL.getWebDriver();
        List<String> profileUrls = profileUrlsScraper.scrape(webDriver);

        List<AttorneyProfileSource> profileSources = new ArrayList<>();
        for (String profileUrl : profileUrls) {
            profileSources.add(profileSourceScraper.scrape(profileUrl, webDriver));
        }

        List<Attorney> attorneys = new ArrayList<>();
        for (AttorneyProfileSource source : profileSources) {
            attorneys.add(profileParser.parse(source));
        }

        attorneyService.saveAll(attorneys);

        return attorneys;
    }
}
