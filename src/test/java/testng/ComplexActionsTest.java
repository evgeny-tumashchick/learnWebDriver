package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import util.ChromeWebDriverSetup;
import util.MyConstants;

public class ComplexActionsTest {
    WebDriver driver;

    @Test
    public void complexActions() {
        driver = new ChromeDriver();
        ChromeWebDriverSetup.setDriver(driver);

        driver.get(MyConstants.SELENIUM_DRAG_DROP_OTHER);

        WebElement boxToDrag = driver.findElement(By.xpath("//div[text()='I can be dragged anywhere']"));
        assert boxToDrag.isDisplayed();

        WebElement destinationBox = driver
                .findElement(By.xpath("//div[text()='I can only be dragged horizonally (x axis)']"));
        assert destinationBox.isDisplayed();

        Actions builder = new Actions(driver);
        //from -> to
        //        builder.dragAndDrop(boxToDrag, destinationBox).perform();
        //from -> to coordinates
        builder.dragAndDropBy(boxToDrag, 100, -100).perform();
    }

    @Test
    public void severalActionsDrawingTest() {
        driver = new ChromeDriver();
        ChromeWebDriverSetup.setDriver(driver);

        driver.get(MyConstants.SELENIUM_DRAW_PAINTER);

        WebElement canvas = driver.findElement(By.id("catch"));

        driver.findElement(By.id("brush")).click();

        Actions builder = new Actions(driver);

        builder.moveToElement(canvas)
                .clickAndHold()
                .moveByOffset(200, 0)
                .moveByOffset(0, 200)
                .moveByOffset(-200, 0)
                .moveByOffset(0, -200)
                .release()
                .perform();
    }
}
