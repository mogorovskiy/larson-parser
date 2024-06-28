package org.mogorovskiy.parser;

import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;

import java.util.List;

public interface ProfileSourceScraper {
    AttorneyProfileSource scrape(String url);
}
