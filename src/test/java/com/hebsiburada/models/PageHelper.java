package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class PageHelper {

    WebDriver driver;

    WebDriverWait wait;
    public PageHelper() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));
    }





    public void waitforElementToBeLocated(WebElement element) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }


    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeys(WebElement sendElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendElement));
        sendElement.sendKeys(value);
    }


    public void sendPressKeyboardKey(WebElement element, Keys key) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(key);
    }


    public void assertEquals(WebElement element , String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), expectedText);
    }
    public void assertLocation(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Sayfa basariyla yuklendi");
        } catch (Exception e) {
            takeScreenshot();
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n" + e);
        }
    }

    public void assertIsTheTextInThisElement(WebElement element, String expectedText) {
        try {
            assertEquals(element, expectedText);
            System.out.println("Beklenilen sayfa basariyla yuklendi");
        } catch (Exception e) {
            takeScreenshot();
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n" + e);
        }
    }

    public void assertIsTheTextOnThisPage(String expectedText) {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        boolean IsThere = bodyText.contains(expectedText);
        if (IsThere) {
            System.out.println("Beklenilen sayfa basariyla yuklendi");
        } else {
            takeScreenshot();
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n");
        }
    }


    public void AssertIsTheProductAddedToTheCart(int beforoAddingCount, int afterAddingCount) {
        int mDifference = afterAddingCount - beforoAddingCount;
        if (mDifference > 0) {
            System.out.println("Sepete urun ekleme islemi basariyla gerceklesmistir");
        } else {
            takeScreenshot();
            Assert.fail("\n" + "Urun sepete eklenmis olmasina ragmen sepetteki urun sayisi artmadi !!!" + "\n");
        }
    }

    public void takeScreenshot(){
        TakesScreenshot screenshot= (TakesScreenshot)driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        Random random= new Random();
        String randomString = String.valueOf(random.nextInt(100000000));
        try {
            Files.move(scrFile.toPath(), new File("screenshots/failImage"+randomString+".png").toPath());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
