package org.mogorovskiy.parser.larson;

import org.mogorovskiy.parser.AttorneyParser;
import org.mogorovskiy.service.AttorneyServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class LarsonParser extends AttorneyParser {

    public LarsonParser(LarsonProfileParser larsonProfileParser, AttorneyServiceImpl attorneyService,
                        LarsonProfileUrlsScraper larsonProfileUrlsScraper, LarsonProfileSourceScraper larsonProfileSourceScraper) {
        super(
                larsonProfileParser,
                attorneyService,
                larsonProfileUrlsScraper,
                larsonProfileSourceScraper
        );
    }
}
