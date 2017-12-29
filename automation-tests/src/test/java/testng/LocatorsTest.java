package testng;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LocatorsTest extends TestBase {

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
