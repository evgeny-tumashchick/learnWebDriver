package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import util.MyConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class HelloWorldTest {

    @Test
    public void googleTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
