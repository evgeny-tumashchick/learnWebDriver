package com.core;

import org.testng.Assert;

import static com.core.WebDriverContainer.getDriver;

public class PageBase {
    protected static void shouldAppear(String title) {
        Assert.assertEquals(getDriver().getTitle(), title);
    }
}
