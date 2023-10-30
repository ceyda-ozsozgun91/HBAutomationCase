package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageHelper{

    public HomePage() {
        WebDriver driver = Driver.getDriver();

        PageFactory.initElements(driver,this);
    }

    //public final String myAccount = "myAccount";
    @FindBy(id="myAccount")
    public WebElement myAccount;

    public void clickMyAccount(){
        click(myAccount);
    }

    @FindBy(id="login")
    public WebElement login;
    public void clickLoginSelection(){
        click(login);
    }
}
