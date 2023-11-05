package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitersTests extends BaseTestClass {

    @Test
    public void waiterTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.id("start")).findElement(By.xpath(".//button")).click();
//        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
        //  //*[@id="start"]/button
        //  /html/body/div[2]/div/div/div[1]/button

        //Thread.sleep(30000);

        // Явные ожижания
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText(), "Hello World!");
        //Assert.assertEquals(driver.findElement(By.cssSelector("#finish > h4")).getText(), "Hello World!");

    }


}
