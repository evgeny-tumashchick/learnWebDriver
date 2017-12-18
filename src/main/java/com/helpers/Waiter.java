package com.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.core.WebDriverContainer.getDriver;

public class Waiter {
    private static final int DEFAULT_TIMEOUT = 10;

    public static void waitFor(ExpectedCondition condition) {
        new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until(condition);
    }

    public static void waitForJquery() {
        new WebDriverWait(getDriver(), DEFAULT_TIMEOUT).until((ExpectedCondition<Boolean>) driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (Boolean) js.executeScript("return jQuery.active === 0");
        });
    }

}
