package com.home_work_01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productDropDown;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement costumerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;
    @FindBy(xpath = "//label[.='MasterCard']")
    WebElement cardType;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expiration;
    @FindBy(xpath = "//a[@class='btn_light']")
    WebElement procesBtn;

    @FindBy(xpath = "//div//preceding-sibling::strong")
    WebElement newOrderAddedMsg;

    public void orderPagFileOut(String product, String quantity, String costumerName,
                                String street, String city, String state, String zipCode,
                                String cardNumber, String expiration) throws InterruptedException {

        productDropDown.click();
        BrowserUtils.selectBy(productDropDown, product, "visibleText");
        this.quantity.sendKeys(quantity);
        this.costumerName.sendKeys(costumerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        BrowserUtils.clickOnElement(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expiration.sendKeys(expiration);
        Thread.sleep(2000);
        BrowserUtils.clickOnElement(procesBtn);
        Thread.sleep(3000);

        Assert.assertTrue(newOrderAddedMsg.isDisplayed());

    }








}
