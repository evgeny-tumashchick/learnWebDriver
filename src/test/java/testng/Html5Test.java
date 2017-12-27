package testng;

import com.core.TestBase;
import com.helpers.Waiter;
import com.util.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.util.URIConstants.SELENIUM_DRAW_PAINTER;
import static com.util.URIConstants.SELENIUM_HTML5_VIDEO;

public class Html5Test extends TestBase {

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

    @Test
    public void videoTest() throws InterruptedException {
        driver.get(SELENIUM_HTML5_VIDEO);

        WebElement videoPlayer = driver.findElement(By.id("video1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String source = (String) js.executeScript("return arguments[0].currentSrc;", videoPlayer);
        double videoDuration = (Double) js.executeScript("return arguments[0].duration", videoPlayer);

        Assert.assertEquals(source, "https://www.w3schools.com/html/mov_bbb.mp4");
        Assert.assertEquals((int)videoDuration, 10);

        js.executeScript("arguments[0].play()", videoPlayer);
        Thread.sleep(4000);
        js.executeScript("arguments[0].pause()", videoPlayer);
        Thread.sleep(2000);
    }
}
