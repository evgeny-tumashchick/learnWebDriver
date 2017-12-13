package com.pages.pageobjectstaticlocators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLoginPageStatic {

    final static Logger logger = LogManager.getLogger(GoogleLoginPageStatic.class);

    private static By loginInput = By.id("identifierId");
    private static By passwordInput = By.cssSelector("[type='password']");
    private static By nextButton = By.id("identifierNext");
    private static By signInButton = By.id("passwordNext");

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
        GoogleHomePageStatic.clickEmailButton(driver);
    }

}
