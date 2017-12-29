package testng;

import com.tumashchick.common.base.TestBase;
import com.tumashchick.common.utils.URIConstants;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

import static org.junit.Assert.assertEquals;

public class ControllingTest extends TestBase {

    @Test(enabled = false)
    public void customWaitTest() {
        Boolean jQueryFinished = new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            @Nullable
            public Boolean apply(@Nullable WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active === 0");
            }
        });
    }

    @Test
    public void multipleWindowTest() {
        driver.get(URIConstants.SELENIUM_MULTIPLE_WINDOWS);

        String defaultHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector(".example>a")).click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        WebElement text = driver.findElement(By.tagName("h3"));
        assertEquals(text.getText(), "New Window");
        driver.close();

        driver.switchTo().window(defaultHandle);

        WebElement defaultText = driver.findElement(By.tagName("h3"));
        assertEquals(defaultText.getText(), "Opening a new window");
    }

    @Test
    public void jsSimpleAlertTest() {
        driver.get(URIConstants.SELENIUM_JAVASCRIPT_ALERTS);

        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        verifyTextInResultSection(driver, "You successfuly clicked an alert");
    }

    @Test
    public void jsConfirmAlertTest() {
        driver.get(URIConstants.SELENIUM_JAVASCRIPT_ALERTS);

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();

        verifyTextInResultSection(driver, "You clicked: Cancel");
    }

    @Test
    public void jsPromptAlertTest() {
        driver.get(URIConstants.SELENIUM_JAVASCRIPT_ALERTS);

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        String textToSend = "TestWebDriverJSAlerts";
        alert.sendKeys(textToSend);
        alert.accept();

        String expectedText = "You entered: " + textToSend;
        verifyTextInResultSection(driver, expectedText);
    }

    @Test
    public void framesTest() {
        driver.get(URIConstants.SELENIUM_NESTED_FRAMES);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "LEFT");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "RIGHT");
    }


    private void verifyTextInResultSection(WebDriver driver, String expectedText) {
        WebElement textResult = driver.findElement(By.id("result"));
        Assert.assertEquals(textResult.getText(), expectedText);
    }
}
