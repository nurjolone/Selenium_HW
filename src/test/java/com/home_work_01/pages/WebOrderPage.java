package com.home_work_01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class WebOrderPage {
    public WebOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//h2")
    WebElement header;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrders;
    @FindBy(xpath = "//a[.='View all products']")
    WebElement viewAllProducts;
    @FindBy (css = "table[class='ProductsTable']")
    WebElement productTable;
    @FindBy(xpath = "//a[.='Order']")
    WebElement order;

    @FindBy(xpath = "//a")
    List<WebElement> hrefValues;


    public void titleAndHeadr(WebDriver driver, String title, String header) {

        Assert.assertEquals(driver.getTitle(), title);
        Assert.assertEquals(BrowserUtils.getText(this.header), header);
    }

    public void allProduct(WebDriver driver, String header) throws InterruptedException {
        BrowserUtils.clickOnElement(viewAllProducts);
        Thread.sleep(2000);

        Assert.assertTrue(productTable.isDisplayed());
        Assert.assertEquals(BrowserUtils.getText(this.header), header);
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
        Thread.sleep(1000);
    }

    public void validateHrefValue() throws InterruptedException {

        Assert.assertTrue(viewAllOrders.getAttribute("href").contains("Default.aspx"));

        Assert.assertTrue(viewAllProducts.getAttribute("href").contains("Products.aspx"));

        Assert.assertTrue(order.getAttribute("href").contains("Process.aspx"));
        Thread.sleep(1000);

    }

    public void orderPageClick() {
        BrowserUtils.clickOnElement(order);
    }
}
