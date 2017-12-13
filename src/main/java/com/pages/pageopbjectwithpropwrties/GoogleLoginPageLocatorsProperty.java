package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLoginPageLocatorsProperty {

    final static Logger logger = LogManager.getLogger(GoogleLoginPageLocatorsProperty.class);

    private static By loginInput = Locators.get("GoogleLoginPage.loginInput");
    private static By passwordInput = Locators.get("GoogleLoginPage.passwordInput");
    private static By nextButton = Locators.get("GoogleLoginPage.nextButton");
    private static By signInButton = Locators.get("GoogleLoginPage.signInButton");

    public static void signInAccount(WebDriver driver, String login, String password) {
        logger.info("Input login");
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(nextButton).click();

        WebDriverWait waitPasswordFieldPresent = new WebDriverWait(driver, 10);
        waitPasswordFieldPresent.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        logger.info("Input password");
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public static void signInAccountOpenMailBox(WebDriver driver, String login, String password) {
        signInAccount(driver, login, password);
        GoogleHomePageLocatorsProperty.clickEmailButton(driver);
    }

}
