package testng;

import com.core.TestBase;
import com.util.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.util.URIConstants.GOOGLE_BY_URI;

public class ScreenshotTest extends TestBase {

    @Test
    public void screenshotTest() throws IOException {
        driver.get(GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("nice picture");
        searchField.submit();

        FileUtils.copyFile(Screenshot.captureScreenshot(driver), new File("d:\\temp\\tstScreenshot.png"));
        driver.quit();
    }

    @Test
    public void screenshotElementTest() throws IOException {
        driver.get(GOOGLE_BY_URI);

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("nice picture");
        searchField.submit();

        WebElement picture = driver.findElement(By.cssSelector(".rg_ul a[href]"));
        FileUtils.copyFile(Screenshot.captureScreenshot(driver, picture), new File("d:\\temp\\tstElementScreenshot.png"));
        driver.quit();
    }
}


