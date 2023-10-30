package com.hebsiburada.utils;

import com.hebsiburada.models.*;
import com.hebsiburada.utils.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Actions {
    public WebDriver driver=Driver.getDriver();
    public WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsFromAbroadPage productsFomAbroadPage;
    private PetshopCategoryPage petshopCategoryPage ;
    private ProductPage productPage;
    private BasketPage basketPage;

    public Actions(){
    }

    public void InitializeDriver(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.petshopCategoryPage= new PetshopCategoryPage();
        this.productsFomAbroadPage= new ProductsFromAbroadPage();
        this.productPage=new ProductPage();
        this.basketPage=new BasketPage();
        driver.get("https://www.hepsiburada.com");
        //driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
    }





    public void LoginWithValidUser(String email, String password){
        homePage=new HomePage();
        loginPage=new LoginPage();
        homePage.clickMyAccount();
        homePage.clickLoginSelection();
        loginPage.sendValidEmailAddress(email);
        loginPage.clickWithEmailLoginButton();
        loginPage.sendValidPassword(password);
        loginPage.clickLoginButton();
        homePage.assertIsTheTextOnThisPage("Jane Doe");
    }

    public void navigateToYurtDisindanPage(){
        driver.get("https://www.hepsiburada.com/kampanyalar/yurt-disindan-urunler?wt_int=hytop.yurtdisi.kampanya");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
       // productsFomAbroadPage.assertIsLocationTheProductsFromAbroadPage();
    }
    public void navigateToProductsInPetShopCategory(){
        //productsFomAbroadPage.clickPetShopCategory();
        driver.get("https://www.hepsiburada.com/kampanyalar/yurt-disindan-urunler?kategori=2147483616&wt_int=hytop.yurtdisi.kampanya");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20L));
        //petshopCategoryPage.assertIsLocationPetshopCategoryPage();

    }

    public void addToChardThirdProduct(){
        petshopCategoryPage= new PetshopCategoryPage();
        petshopCategoryPage.clickThirdProduct();
        productPage= new ProductPage();
        productPage.clickAddToChartButton();

    }

    public void clickGoToBasketFromProductPage()
    {
        this.productPage=new ProductPage();
        productPage.clickGoToBasketFromProductPage();
        this.basketPage=new BasketPage();

    }

    public void addOneMoreProductAndCheckTheBasket() throws InterruptedException {
        basketPage= new BasketPage();
        basketPage.clickAddOneProductButton();
        basketPage.assertEquals(basketPage.totalBasketPrice,"1.232,92");
    }

    public void deleteProductsAndCheckTheBasket() throws InterruptedException {
        basketPage= new BasketPage();
        basketPage.clickDeleteProductsButton();
        basketPage.clickDeleteAllConfirmationSuccessButton();
        basketPage.assertLocation(basketPage.noProductInBasketValidationMessage);
    }








}
