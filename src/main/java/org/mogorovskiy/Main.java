package org.mogorovskiy;

import org.mogorovskiy.parser.AttorneyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Autowired
    private AttorneyParser attorneyParser;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            attorneyParser.parse();
        };
    }
}
