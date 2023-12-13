package com.home_work_01.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewAllOrdersPage {
    public ViewAllOrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[2]/td//following-sibling::td")
    List<WebElement> newOrderInfo;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrder;

    public void inputInformationCheck(String costumerName, String product, String quantity,
                                      String street, String city, String state, String zipCode, String cardType,
                                      String cardNumber, String expiration) throws InterruptedException {
        List<String> expected = Arrays.asList(costumerName, product, quantity, street, city, state, zipCode, cardType,
                cardNumber, expiration);


        viewAllOrder.click();
        Thread.sleep(1000);

        List<String> actual = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            if (i == 3) {
                continue;
            } else {
                actual.add(BrowserUtils.getText(newOrderInfo.get(i)));
            }
        }

        for (int i = 0; i < actual.size(); i++) {

            Assert.assertEquals(actual.get(i), expected.get(i));

        }

    }

}








