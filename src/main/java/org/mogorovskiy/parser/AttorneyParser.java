package org.mogorovskiy.parser;

import lombok.NoArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.impl.ProfileParserImpl;
import org.mogorovskiy.parser.impl.ProfileSourceScraperImpl;
import org.mogorovskiy.parser.impl.ProfileUrlsScraperImpl;
import org.mogorovskiy.selenium.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class AttorneyParser {

    private final ProfileUrlsScraper profileUrlsScraper = new ProfileUrlsScraperImpl();
    private final ProfileSourceScraper profileSourceScraper = new ProfileSourceScraperImpl();
    private final ProfileParser profileParser = new ProfileParserImpl();

    private static final WebDriverUtil DRIVER_UTIL = new WebDriverUtil();

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

        for (Attorney attorney : attorneys) {
            System.out.println(attorney);
            //break; //TODO!
        }

        return attorneys;
    }
}
