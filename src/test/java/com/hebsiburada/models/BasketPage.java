package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasketPage extends PageHelper{
    public BasketPage() {
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#basket_payedPrice > div")
    public WebElement totalBasketPrice;

    @FindBy(xpath = "//a[.='Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)']")
    public WebElement productNameInBasket;
    public String getexpectedProductNameString(){
    String testData= "Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)";
        return testData;
    }

    @FindBy(css = "[aria-label='Ürünü Arttır'] > [width='32']")
    private WebElement addOneProductButton;

    public void clickAddOneProductButton() throws InterruptedException {
        click(addOneProductButton);
        Thread.sleep(2000);
    }
    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement basketQuantitiy;

    public String getValueofBasketQuantitiy(){
        String quantitiy= basketQuantitiy.getCssValue("value");
        return quantitiy;
    }

    @FindBy(css = ".basket_delete_1U-UX")
    private WebElement deleteProductsButton;

    public void clickDeleteProductsButton() throws InterruptedException {
        click(deleteProductsButton);
        Thread.sleep(2000);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[1]/header/div[3]/div/div/div/button")
    private WebElement deleteAllConfirmationSuccessButton;

    public void clickDeleteAllConfirmationSuccessButton(){
        click(deleteAllConfirmationSuccessButton);
    }

    @FindBy(xpath = "//h1[.='Sepetin şu an boş']")
    public WebElement noProductInBasketValidationMessage;

}
