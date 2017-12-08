package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import util.MyConstants;

import java.util.concurrent.TimeUnit;

public class LocatorsTest {
    @Test
    public void locatorsTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(MyConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello, world");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement serachTextResult = driver.findElement(By.linkText("Hello, world! — Википедия"));
        serachTextResult.click();

//        List<WebElement> searchResults = driver.findElements(By.className("r"));
//        System.out.println(searchResults.size());

//        WebElement firstSearchResult = driver.findElement(By.className("r"));
//        WebElement resultLink = firstSearchResult.findElement(By.tagName("a"));
//        resultLink.click();
    }

}
