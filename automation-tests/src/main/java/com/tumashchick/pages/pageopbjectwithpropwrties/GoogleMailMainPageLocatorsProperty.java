package com.tumashchick.pages.pageopbjectwithpropwrties;

import com.tumashchick.common.base.PageBase;
import com.tumashchick.core.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.tumashchick.common.base.WebDriverContainer.findElements;

public class GoogleMailMainPageLocatorsProperty extends PageBase {

    private static By emailLinks = Locators.get("GoogleMailMainPage.emailLinks");

    private static final String TITLE = "Входящие - tumashchick@gmail.com - Gmail";

    public static int countEmails() {
        List<WebElement> emails = findElements(emailLinks);
        return emails.size();
    }

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }
}
