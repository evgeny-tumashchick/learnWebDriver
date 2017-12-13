package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePageLocatorsProperty {

    final static Logger logger = LogManager.getLogger(GoogleMailMainPageLocatorsProperty.class);

    private static final By loginButton = Locators.get("GoogleHomePage.loginButton");
    private static final By emailButton = Locators.get("GoogleHomePage.emailButton");

    public static void clickLoginButton(WebDriver driver) {
        logger.info("Click login button to open user login form");
        driver.findElement(loginButton).click();
    }

    public static void clickEmailButton(WebDriver driver) {
        logger.info("Click email button to enter email box");
        driver.findElement(emailButton).click();
    }
}
