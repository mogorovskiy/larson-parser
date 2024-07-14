package org.mogorovskiy.util;

import org.mogorovskiy.parser.larson.LarsonParser;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class AppConfig {

    @Autowired
    private LarsonParser larsonParser;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            larsonParser.parse();
        };
    }
}