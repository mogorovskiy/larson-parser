package org.mogorovskiy.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCompletelyLoaded {

    public static void pageCompletelyLoaded(WebDriver driver) {
        new WebDriverWait(driver, 30).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
