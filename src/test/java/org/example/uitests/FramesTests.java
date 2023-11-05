package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTests extends BaseTestClass {
    @Test
    public void switchToFram() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();

//        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);

    }

    @Test
    public void switchToFrameLeft() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "LEFT");

    }

    @Test
    public void switchToFrameMiddle() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "MIDDLE");

    }

//    @Test
//    public void switchToFramHWLeft() {
//        driver.get("https://the-internet.herokuapp.com/nested_frames");
//        driver.switchTo().frame("frame-top");
//
//        driver.switchTo().frame("frame-left");
//        String body = driver.findElement(By.xpath("//body")).getText();
//        Assert.assertEquals(body, "LEFT");
//
//        driver.switchTo().defaultContent();
//
//        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
//    }
//
//    @Test(dataProvider = "dataProviderFrames")
//    public void switchToFramHWCommon(String frameMain, String subFrame, String text) {
//        driver.get("https://the-internet.herokuapp.com/nested_frames");
//        if (!frameMain.equals("")) {
//            driver.switchTo().frame(frameMain);
//        }
//
//        driver.switchTo().frame(subFrame);
//        String body = driver.findElement(By.xpath("//body")).getText();
//        Assert.assertEquals(body, text);
//
//        driver.switchTo().defaultContent();
//
//        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
//    }
//
//    @DataProvider
//    public Object[] dataProviderFrames () {
//        return new Object[][] {
//                {"", "frame-bottom", "BOTTOM"},
//                {"frame-top", "frame-left", "LEFT"},
//                {"frame-top", "frame-middle", "MIDDLE"},
//                {"frame-top", "frame-right", "RIGHT"}
//        };
//    }

}
