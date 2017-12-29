package testng;

import com.tumashchick.common.utils.URIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.ChromeWebDriverSetup;

public class LocatorsTest {

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
    public void locatorsTest() {
        driver.get(URIConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello, world");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement searchTextResult = driver.findElement(By.linkText("Hello, world! — Википедия"));
        searchTextResult.click();

//        List<WebElement> searchResults = driver.findElements(By.className("r"));
//        System.out.println(searchResults.size());

//        WebElement firstSearchResult = driver.findElement(By.className("r"));
//        WebElement resultLink = firstSearchResult.findElement(By.tagName("a"));
//        resultLink.click();
    }

}
