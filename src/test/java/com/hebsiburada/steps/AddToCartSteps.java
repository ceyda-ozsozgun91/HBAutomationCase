package com.hebsiburada.steps;

import com.hebsiburada.models.*;
import com.hebsiburada.utils.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartSteps {

    private Actions actions= new Actions();



    @Given("Kullanici login olmadan Yurtdisindan Petshop kategorisine gider")
    public void AddToCartNonLoggedOnUserFirstStep(){
        actions.InitializeDriver();
        actions.navigateToYurtDisindanPage();
        //Driver.getDriver().findElement(By.xpath("//div[@id='AllCategories.CategoryId']//div[17]/div/div/div")).click();
        //Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        actions.navigateToProductsInPetShopCategory();
        System.out.println("Kullanici login olmadan Yurtdisindan Petshop kategorisine gitti");


    }
    @Given("Valid kullanici ile login olunur")
    public void LoginWithValidUser()
    {
        actions.InitializeDriver();
        actions.LoginWithValidUser("jane.doe.110391@gmail.com","RFVtgb45!!");

        System.out.println("Valid kullanici ile login olundu");
    }
    @Given("Yurtdisindan Petshop kategorisine gider")
    public void AddToCartFirstStep(){
        this.actions= new Actions();
        actions.navigateToYurtDisindanPage();
        actions.navigateToProductsInPetShopCategory();
        System.out.println("Kullanici Yurtdisindan Petshop kategorisine gitti");


    }
    @Given("Kullanici kategorideki bir urunu sepetine ekler")
    public void AddToCartSecondStep() throws InterruptedException {

        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20L));
        actions.addToChardThirdProduct();

        System.out.println("Kullanici kategorideki bir urunu sepetine ekledi");
    }

    @Given("Kullanici sepetine gider")
    public void AddToCartThirdStep(){
        actions.clickGoToBasketFromProductPage();
        System.out.println("Kullanici sepetine gitti");
    }

    @Then("kullanici sepetindeki ürünü ve fiyatini kontrol eder")
    public void AddToCartFourthStep(){
        actions.checkBasket();
        System.out.println("Sepetteki ürün ve fiyat kontrol edildi.");
    }

    @Given("kullanici sepetindeki urun sayisini bir artirir ve bilgileri kontrol eder")
    public void AddToCartFifthStep() throws InterruptedException {
        actions.addOneMoreProductAndCheckTheBasket();
        System.out.println("kullanici sepetindeki urun sayisini bir artirdi ve bilgileri kontrol etti");
    }

    @Given("kullanici sepetindeki urunu siler ve bilgileri kontrol eder")
    public void AddToCartSixthStep() throws InterruptedException {
        actions.deleteProductsAndCheckTheBasket();
        System.out.println("kullanici sepetindeki urunu sildi ve bilgileri kontrol etti");

    }




}
