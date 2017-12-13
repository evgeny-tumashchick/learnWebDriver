package com.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.core.WebDriverContainer.Driver.Chrome;
import static com.core.WebDriverContainer.getDriver;
import static com.core.WebDriverContainer.quitDriver;
import static com.core.WebDriverContainer.setDriver;

public abstract class TestBase {

    final static Logger logger = LogManager.getLogger(TestBase.class);

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        setDriver(Chrome);
        driver = getDriver();
    }

    @AfterTest
    public void teardown() {
        quitDriver();
    }
}
