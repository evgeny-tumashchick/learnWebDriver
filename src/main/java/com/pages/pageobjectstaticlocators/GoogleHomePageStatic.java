package com.pages.pageobjectstaticlocators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePageStatic {

    final static Logger logger = LogManager.getLogger(GoogleMailMainPageStatic.class);

    private static final By loginButton = By.id("gb_70");
    private static final By emailButton = By.cssSelector("div>a[href='https://mail.google.com/mail/?tab=wm']");

    public static void clickLoginButton(WebDriver driver) {
        logger.info("Click login button to open user login form");
        driver.findElement(loginButton).click();
    }

    public static void clickEmailButton(WebDriver driver) {
        logger.info("Click email button to enter email box");
        driver.findElement(emailButton).click();
    }
}
