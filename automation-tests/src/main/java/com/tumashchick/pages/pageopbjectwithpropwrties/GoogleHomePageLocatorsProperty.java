package com.tumashchick.pages.pageopbjectwithpropwrties;

import com.tumashchick.common.base.PageBase;
import com.tumashchick.core.Locators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.tumashchick.common.base.WebDriverContainer.findElement;

public class GoogleHomePageLocatorsProperty extends PageBase {

    final static Logger logger = LogManager.getLogger(GoogleMailMainPageLocatorsProperty.class);

    private static final String TITLE = "Google";

    private static final By loginButton = Locators.get("GoogleHomePage.loginButton");
    private static final By emailButton = Locators.get("GoogleHomePage.emailButton");

    public static void clickLoginButton() {
        shouldAppear();
        logger.info("Click login button to open user login form");
        findElement(loginButton).click();
    }

    public static void clickEmailButton() {
        logger.info("Click email button to enter email box");
        findElement(emailButton).click();
    }

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }
}
