package com.pages.pageopbjectwithpropwrties;

import com.core.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.core.WebDriverContainer.findElements;

public class GoogleMailMainPageLocatorsProperty {

    private static By emailLinks = Locators.get("GoogleMailMainPage.emailLinks");

    public static int countEmails() {
        List<WebElement> emails = findElements(emailLinks);
        return emails.size();
    }
}
