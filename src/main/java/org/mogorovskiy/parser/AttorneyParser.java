package org.mogorovskiy.parser;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.selenium.WebDriverUtil;
import org.mogorovskiy.service.AttorneyService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public static final WebDriver WEB_DRIVER = new ChromeDriver();

    public List<Attorney> parse() throws IOException {
        List<String> profileUrls = profileUrlsScraper.scrape(WEB_DRIVER);

        List<AttorneyProfileSource> profileSources = new ArrayList<>();
        for (String profileUrl : profileUrls) {
            profileSources.add(profileSourceScraper.scrape(profileUrl, WEB_DRIVER));
        }

        List<Attorney> attorneys = new ArrayList<>();
        for (AttorneyProfileSource source : profileSources) {
            attorneys.add(profileParser.parse(source));
        }

        attorneyService.save(attorneys);

        return attorneys;
    }
}
