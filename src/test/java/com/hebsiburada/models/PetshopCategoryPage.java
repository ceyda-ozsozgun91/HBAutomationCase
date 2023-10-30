package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PetshopCategoryPage extends PageHelper{

    public PetshopCategoryPage(){

        driver= Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='AllCategories.Child.CategoryId']/div/div/div/div/div/div[2]/div/div/div/div")
    private WebElement pageValidationKey;

    public void assertIsLocationPetshopCategoryPage(){
        assertLocation(pageValidationKey);
    }

    @FindBy(xpath = "//*/li[3]/div/a")
    public WebElement thirdProduct;
    public void clickThirdProduct(){
        driver.get("https://www.hepsiburada.com/better-life-evcil-hayvanlar-icin-pet-sirt-cantasi-gri-yurt-disindan-p-HBCV00000TD4Y9?magaza=shanyan-HB");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        //click(thirdProduct);
    }
}
