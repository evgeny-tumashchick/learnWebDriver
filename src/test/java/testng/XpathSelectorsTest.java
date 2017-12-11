package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.ChromeWebDriverSetup;
import util.MyConstants;

public class XpathSelectorsTest {

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
    public void xpathSelectorsTest() {
        driver.get(MyConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello, world");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement xpathSelectorResult = driver.findElement(By.xpath("//*[@class='rc']//a"));
        xpathSelectorResult.click();
    }

}
