package org.mogorovskiy.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    private static final WebDriver WEB_DRIVER;

    static {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WEB_DRIVER = new ChromeDriver();
    }

    public static WebDriver getWebDriver() {
        return WEB_DRIVER;
    }
}
