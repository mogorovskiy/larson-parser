package org.mogorovskiy.parser;

import org.mogorovskiy.selenium.WebDriverUtil;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface ProfileUrlsScraper {
    List<String> scrape(WebDriver connection);
}
