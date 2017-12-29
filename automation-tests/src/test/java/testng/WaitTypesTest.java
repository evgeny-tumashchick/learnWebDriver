package testng;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTypesTest extends TestBase {

    @Test
    public void waitTypesTest() {
        driver.get(URIConstants.SELENIUM_DYNAMIC_LOAD);

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        WebDriverWait waitHelloWorld = new WebDriverWait(driver, 10);

        WebElement helloWorld = waitHelloWorld.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish>h4")));
        helloWorld.click();
    }

}
