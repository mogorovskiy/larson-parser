package org.mogorovskiy.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/mogorovskiy/selenium/chromedriver.exe");
    }

    public WebDriver getWebDriver() {
        return new ChromeDriver();
    }
}
