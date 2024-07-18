package org.mogorovskiy;

import lombok.RequiredArgsConstructor;
import org.mogorovskiy.parser.larson.LarsonParser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttorneyParserApplicationRunner implements ApplicationRunner {

    private final LarsonParser larsonParser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        larsonParser.parse();
    }
}
