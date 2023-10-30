package com.hebsiburada.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public Driver(){}
    private static WebDriver driver;
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();



    public static WebDriver getDriver(){

        if (browserName.get()==null){
            browserName.set("firefox");
        }

        if (threadDriver.get()==null){

            if (browserName.get().equals("firefox")) {
                System.setProperty("web-driver.gecko.driver", "C:\\Users\\ceyda.local\\Selenium\\geckodriver.exe");
                threadDriver.set(new FirefoxDriver());
            } else {
                System.setProperty("web-driver.chrome.driver", "C:/Users/ceyda.local/Selenium/ChromeDriver/chromedriver.exe");
                threadDriver.set(new ChromeDriver());
            }

        } return threadDriver.get();
    }



    public static void quitDriver(){


        if (threadDriver.get()!=null){

            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver=null;

            threadDriver.set(driver);
        }

    }
}
