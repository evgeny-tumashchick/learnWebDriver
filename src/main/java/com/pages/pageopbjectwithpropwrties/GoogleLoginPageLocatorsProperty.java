package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.core.WebDriverContainer.findElement;
import static com.core.WebDriverContainer.getDriver;

public class GoogleLoginPageLocatorsProperty {

    final static Logger logger = LogManager.getLogger(GoogleLoginPageLocatorsProperty.class);

    private static By loginInput = Locators.get("GoogleLoginPage.loginInput");
    private static By passwordInput = Locators.get("GoogleLoginPage.passwordInput");
    private static By nextButton = Locators.get("GoogleLoginPage.nextButton");
    private static By signInButton = Locators.get("GoogleLoginPage.signInButton");

    public static void signInAccount(String login, String password) {
        logger.info("Input login");
        findElement(loginInput).sendKeys(login);
        findElement(nextButton).click();

        WebDriverWait waitPasswordFieldPresent = new WebDriverWait(getDriver(), 10);
        waitPasswordFieldPresent.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

        logger.info("Input password");
        findElement(passwordInput).sendKeys(password);
        findElement(signInButton).click();
    }

    public static void signInAccountOpenMailBox(String login, String password) {
        signInAccount(login, password);
        GoogleHomePageLocatorsProperty.clickEmailButton();
    }

}
