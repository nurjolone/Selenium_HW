package com.home_work_01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "#ctl00_MainContent_username")
    WebElement userName;
    @FindBy(css = "#ctl00_MainContent_password")
    WebElement password;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement submitBtn;

    public void mainPageValidation(WebDriver driver, String userName,String password) throws InterruptedException {

       Assert.assertEquals(driver.getTitle(),"Web Orders Login");


       this.userName.sendKeys(userName);
       this.password.sendKeys(password);
       Thread.sleep(400);

       submitBtn.click();


       Assert.assertEquals(driver.getTitle(),"Web Orders");

       WebElement header = driver.findElement(By.xpath("//h2"));

       Assert.assertEquals(BrowserUtils.getText(header),"List of All Orders");





    }


}
