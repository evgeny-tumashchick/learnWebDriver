package com.tumashchick.pages.pageobjectstaticlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMailMainPageStatic {

    private static By emailLinks = By.cssSelector(("div[role='tabpanel'] tbody>tr"));

    public static int countEmails(WebDriver driver) {
        List<WebElement> emails = driver.findElements(emailLinks);
        return emails.size();
    }
}
