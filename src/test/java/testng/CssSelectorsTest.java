package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import util.ChromeWebDriverSetup;
import util.MyConstants;

public class CssSelectorsTest {

    @Test
    public void cssSelectorsTest() {
        WebDriver driver = new ChromeDriver();
        ChromeWebDriverSetup.setDriver(driver);

        driver.get(MyConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello, world");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement cssElement = driver.findElement(By.cssSelector(".r>a[href*='helloworld.by']"));
        cssElement.click();
    }
}
