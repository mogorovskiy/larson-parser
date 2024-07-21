package org.mogorovskiy.parser;

import org.mogorovskiy.model.AttorneyProfileSource;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface ProfileSourceScraper {
    AttorneyProfileSource scrape(String url, WebDriver webDriver) throws IOException;
}
