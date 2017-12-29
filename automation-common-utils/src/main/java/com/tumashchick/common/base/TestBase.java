package com.tumashchick.common.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class TestBase {

    final static protected Logger logger = LogManager.getLogger(TestBase.class);

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverContainer.setDriver(WebDriverContainer.Driver.Chrome);
        driver = WebDriverContainer.getDriver();
    }

    @AfterTest
    public void teardown() {
        WebDriverContainer.quitDriver();
    }
}
