package com.automation.tests.day12;

import com.automation.tests.day11.JavaScriptExecutor;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private WebDriver driver;



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }


    @Test
    public void verifyTitle(){
        String expected = "Practice";

        // we create  JavascriptExecutor object by casting webDriver object
       JavascriptExecutor js = (JavascriptExecutor) driver;

        // executeScript - this method executes javascript code
        // we provide js code as a string
        // return document.title --> javascript code
        // document --> represents HTML page
        // toString() --> to avoid additional casting from Object to String

       String actual = (String) js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
