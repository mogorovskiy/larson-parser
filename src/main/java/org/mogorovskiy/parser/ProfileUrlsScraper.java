package org.mogorovskiy.parser;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfileUrlsScraper {
    List<String> scrape(WebDriver connection);
}
