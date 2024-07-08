package org.mogorovskiy.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverWait {

    private void waitLoad (WebDriver wb) {
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.WebDriverWait(wb,
                5).withMessage("Element was not found");
    }
}
