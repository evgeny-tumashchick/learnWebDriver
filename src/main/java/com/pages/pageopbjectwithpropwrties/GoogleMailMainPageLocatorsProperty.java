package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMailMainPageLocatorsProperty {

    private static By emailLinks = Locators.get("GoogleMailMainPage.emailLinks");

    public static int countEmails(WebDriver driver) {
        List<WebElement> emails = driver.findElements(emailLinks);
        return emails.size();
    }
}
