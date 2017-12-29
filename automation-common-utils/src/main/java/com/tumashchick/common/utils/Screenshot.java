package com.tumashchick.common.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Screenshot {

    public enum Result {MATCH, SIZE_MISMATCH, PIXEL_MISMATCH}

    public static File captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static File captureScreenshot(WebDriver driver, WebElement element) throws IOException {
        File screenshot = captureScreenshot(driver);
        BufferedImage img = ImageIO.read(screenshot);

        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        Rectangle rectangle = new Rectangle(width, height);
        Point point = element.getLocation();

        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), rectangle.width, rectangle.height);
        ImageIO.write(dest, "png", screenshot);

        return screenshot;
    }

    public static Result compareImages(String baseFile, String actualFile) throws InterruptedException {
        Result compareResult = Result.PIXEL_MISMATCH;

        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);

        PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
        PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
        int[] baseImageData = null;
        int[] actualImageData = null;

        if (baseImageGrab.grabPixels()) {
            baseImageData = (int[]) baseImageGrab.getPixels();
        }
        if (actualImageGrab.grabPixels()) {
            actualImageData = (int[]) actualImageGrab.getPixels();
        }

        if ((baseImageGrab.getHeight() != actualImageGrab.getHeight()) || (baseImageGrab.getWidth() != actualImageGrab.getWidth())) {
            compareResult = Result.SIZE_MISMATCH;
        } else if (Arrays.equals(baseImageData, actualImageData)) {
            compareResult = Result.MATCH;
        }
        return compareResult;
    }
}
