package com.home_work_01.test;

import com.home_work_01.pages.MainPage;
import com.home_work_01.pages.OrderPage;
import com.home_work_01.pages.ViewAllOrdersPage;
import com.home_work_01.pages.WebOrderPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;


public class TestRuner extends TestBases {

    private void MainclassLoginClas() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.mainPageValidation(driver, ConfigReader.readProperty("userName"),
                ConfigReader.readProperty("password"));

    }

    @Test(priority = 1)
    public void test_case_1() throws InterruptedException {
        MainclassLoginClas();
        WebOrderPage webOrderPage = new WebOrderPage(driver);
        webOrderPage.titleAndHeadr(driver, "Web Orders", "List of All Orders");
    }

    @Test(priority = 2)
    public void test_case_2() throws InterruptedException {
        MainclassLoginClas();
        WebOrderPage webOrderPage = new WebOrderPage(driver);
        webOrderPage.allProduct(driver, "List of Products");

    }

    @Test(priority = 3)
    public void test_case_3() throws InterruptedException {
        MainclassLoginClas();

        WebOrderPage webOrderPage = new WebOrderPage(driver);
        webOrderPage.validateHrefValue();
    }


    @Parameters({"product1", "quantity", "costumerName",
            "street", "city", "state", "zipCode",
            "cardNumber", "expiration"})

    @Test(priority = 4)
    public void test_case_4(String product, String quantity, String costumerName,
                            String street, String city, String state, String zipCode,
                            String cardNumber, String expiration) throws InterruptedException {
        MainclassLoginClas();
        WebOrderPage webOrderPage = new WebOrderPage(driver);
        webOrderPage.orderPageClick();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.orderPagFileOut(product, quantity, costumerName,
                street, city, state, zipCode,
                cardNumber, expiration);

        ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage(driver);

        viewAllOrdersPage.inputInformationCheck("CodeFish IT School", "ScreenSaver", "5",
                "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard",
                "444993876233", "03/24");






}}




