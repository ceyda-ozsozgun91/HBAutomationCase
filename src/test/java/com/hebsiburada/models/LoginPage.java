package com.hebsiburada.models;

import com.hebsiburada.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageHelper {
    public LoginPage() {
        driver=Driver.getDriver();

        PageFactory.initElements(driver,this);
    }


    @FindBy(id="txtUserName")
    public WebElement emailLabel;
    public void sendValidEmailAddress(String email){
        sendKeys(emailLabel,email);
    }

    @FindBy(id="btnLogin")
    public WebElement loginButton;
    public void clickWithEmailLoginButton(){
        click(loginButton);
    }
    @FindBy(id="txtPassword")
    public WebElement passwordLabel;
    public void sendValidPassword(String password){
        sendKeys(passwordLabel,password);
    }

    @FindBy(id="btnEmailSelect")
    public WebElement LoginButton;
    public void clickLoginButton(){
        click(LoginButton);
    }

}
