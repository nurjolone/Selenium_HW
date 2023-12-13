package com.home_work_01.test;

import com.home_work_01.pages.WebOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBases {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("url"));


    }

}
