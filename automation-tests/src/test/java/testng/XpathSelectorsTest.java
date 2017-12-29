package testng;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class XpathSelectorsTest extends TestBase {

    @Test
    public void xpathSelectorsTest() {
        driver.get(URIConstants.GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Hello, world");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        WebElement xpathSelectorResult = driver.findElement(By.xpath("//*[@class='rc']//a"));
        xpathSelectorResult.click();
    }
}
