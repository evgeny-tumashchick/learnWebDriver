package com.tumashchick.common.base;

import org.testng.Assert;

public class PageBase {
    protected static void shouldAppear(String title) {
        Assert.assertEquals(WebDriverContainer.getDriver().getTitle(), title);
    }
}
