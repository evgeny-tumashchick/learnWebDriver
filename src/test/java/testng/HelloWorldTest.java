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

import java.util.List;

import static org.testng.Assert.fail;

public class HelloWorldTest {

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
    public void googleTest() {
        driver.get(MyConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");

        searchField.submit();

        List<WebElement> searchResults = driver.findElements(By.cssSelector(".r"));

        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains("selenium")) {
                fail("Not all elements contain search param");
            }
        }

        driver.quit();
    }

}
