package org.mogorovskiy.parser;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;
import org.mogorovskiy.parser.impl.ProfileSourceScraperImpl;
import org.mogorovskiy.parser.impl.ProfileUrlsScraperImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class AttorneyParser {

    private final ProfileUrlsScraper profileUrlsScraper = new ProfileUrlsScraperImpl();
    private final ProfileSourceScraper profileSourceScraper = new ProfileSourceScraperImpl();

    public List<Attorney> parse() {
        List<String> profileUrls = profileUrlsScraper.scrape();

        List<AttorneyProfileSource> profileSources = new ArrayList<>();
        for (String profileUrl : profileUrls) {
            profileSources.add(profileSourceScraper.scrape(profileUrl));
        }

        List<Attorney> attorneys = new ArrayList<>();
        for (AttorneyProfileSource source : profileSources) {
            //attorneys.add(profileParser.parse(source));
        }

        return attorneys;
    }
}
