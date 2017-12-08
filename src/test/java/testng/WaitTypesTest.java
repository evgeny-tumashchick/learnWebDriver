package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import util.MyConstants;

public class WaitTypesTest {
    @Test
    public void waitTypesTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
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
