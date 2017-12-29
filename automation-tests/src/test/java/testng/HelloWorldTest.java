package testng;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.fail;

public class HelloWorldTest extends TestBase {

    @Test
    public void googleTest() {
        driver.get(URIConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");

        searchField.submit();

        List<WebElement> searchResults = driver.findElements(By.cssSelector(".r"));

        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains("selenium")) {
                fail("Not all elements contain search param");
            }
        }
    }
}
