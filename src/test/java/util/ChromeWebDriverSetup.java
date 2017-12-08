package util;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ChromeWebDriverSetup {
    public static void setDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
