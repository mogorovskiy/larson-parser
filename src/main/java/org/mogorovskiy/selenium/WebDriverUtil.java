package org.mogorovskiy.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/mogorovskiy/selenium/chromedriver.exe");
    }

    public static final WebDriver WEB_DRIVER = new ChromeDriver();
}
