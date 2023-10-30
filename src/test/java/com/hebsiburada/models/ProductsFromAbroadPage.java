package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductsFromAbroadPage extends PageHelper{
    public ProductsFromAbroadPage(){

        driver= Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Yurt Dışından Ürünler']")
    private WebElement pageValidationKey;

    public void assertIsLocationTheProductsFromAbroadPage(){
        assertLocation(pageValidationKey);
    }

    @FindBy(xpath = "//div[@id='AllCategories.CategoryId']//div[17]/div/div/div")
    private WebElement petShopCategorySelection;

    public void clickPetShopCategory(){

        click(petShopCategorySelection);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
    }


}
