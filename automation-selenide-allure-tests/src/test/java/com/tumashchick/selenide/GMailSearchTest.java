package com.tumashchick.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.tumashchick.common.utils.URIConstants.GOOGLE_BY_URI;

public class GMailSearchTest {

    @Test
    public void gMailSearchTest() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

        String searchText = "Selenide";

        open(GOOGLE_BY_URI);

        $(By.name("q")).sendKeys(searchText);
        $(By.name("q")).submit();
        $("h3.r a").shouldHave(Condition.text(searchText));
    }
}
