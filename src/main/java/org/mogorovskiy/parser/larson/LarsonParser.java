package org.mogorovskiy.parser.larson;

import org.mogorovskiy.parser.AttorneyParser;
import org.mogorovskiy.repository.AttorneyRepository;
import org.mogorovskiy.service.AttorneyServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class LarsonParser extends AttorneyParser {

    public LarsonParser(AttorneyRepository repository) {
        super(
                new LarsonProfileParser(),
                new AttorneyServiceImpl(repository),
                new LarsonProfileUrlsScraper(),
                new LarsonProfileSourceScraper()
        );
    }
}
