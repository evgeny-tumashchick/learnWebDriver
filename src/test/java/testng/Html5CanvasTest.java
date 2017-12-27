package testng;

import com.core.TestBase;
import com.helpers.Waiter;
import com.util.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.util.URIConstants.SELENIUM_DRAW_PAINTER;

public class Html5CanvasTest extends TestBase {

    @Test
    public void canvasTest() throws IOException, InterruptedException {
        String initialFilePath = "d:\\temp\\initialFile.png";
        String actualFilePath = "d:\\temp\\actualFile.png";
        driver.get(SELENIUM_DRAW_PAINTER);

        WebElement canvas = driver.findElement(By.id("catch"));
        Waiter.waitFor(ExpectedConditions.visibilityOf(canvas));

        driver.findElement(By.id("brush")).click();

        FileUtils.copyFile(Screenshot.captureScreenshot(driver, canvas), new File(initialFilePath));

        Actions builder = new Actions(driver);
        builder.moveToElement(canvas)
                .clickAndHold()
                .moveByOffset(200, 0)
                .moveByOffset(0, 200)
                .moveByOffset(-200, 0)
                .moveByOffset(0, -200)
                .release()
                .perform();

        FileUtils.copyFile(Screenshot.captureScreenshot(driver, canvas), new File(actualFilePath));

        Assert.assertEquals(Screenshot.Result.PIXEL_MISMATCH, Screenshot.compareImages(initialFilePath, actualFilePath));
    }
}
