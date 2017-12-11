package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.ChromeWebDriverSetup;
import util.MyConstants;

public class WaitTypesTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        ChromeWebDriverSetup.setDriver(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void waitTypesTest() {
        //                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //        //java script running on the page will be waited. Only asinc java script
        //        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        //        //waits the page load
        //        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get(MyConstants.SELENIUM_DYNAMIC_LOAD);

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        WebDriverWait waitHelloWorld = new WebDriverWait(driver, 10);

        WebElement helloWorld = waitHelloWorld.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish>h4")));
        helloWorld.click();
    }

}
