package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.core.WebDriverContainer.findElement;

public class GoogleHomePageLocatorsProperty {

    final static Logger logger = LogManager.getLogger(GoogleMailMainPageLocatorsProperty.class);

    private static final By loginButton = Locators.get("GoogleHomePage.loginButton");
    private static final By emailButton = Locators.get("GoogleHomePage.emailButton");

    public static void clickLoginButton() {
        logger.info("Click login button to open user login form");
        findElement(loginButton).click();
    }

    public static void clickEmailButton() {
        logger.info("Click email button to enter email box");
        findElement(emailButton).click();
    }
}
