package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductPage extends PageHelper{
    public ProductPage(){

        driver= Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "addToCart")
    private WebElement addToCartButton;

    public void assertIsLocationProductPage() {
        assertLocation(addToCartButton);
    }

    public void clickAddToChartButton() throws InterruptedException {
        click(addToCartButton);
        Thread.sleep(2000);


    }

    @FindBy(xpath = "//button[.='Sepete git']")
    private WebElement goToBasketFromProductPageButton;

    public void clickGoToBasketFromProductPage(){
        driver.get("https://checkout.hepsiburada.com/sepetim");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        //wait.until(ExpectedConditions.elementToBeClickable(goToBasketFromProductPageButton));
       // goToBasketFromProductPageButton.click();

    }
}
